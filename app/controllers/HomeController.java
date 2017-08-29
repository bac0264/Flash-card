package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.Card;
import play.libs.Json;
import play.mvc.*;

import java.sql.*;
import java.util.Vector;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    private String url = "jdbc:mysql://localhost:3306/playdb";
    private String username = "root";
    private String password = "";
    @Inject
    private static Card defaultCard = new Card("empty", "empty");

    private Card mapToCard(ResultSet rs) throws SQLException {
        String keyword = rs.getString("keyword");
        String code = rs.getString("code");
        return new Card(keyword, code);
    }


    public Result query() throws SQLException {
        //TODO - query database
        Vector<Card> list = new Vector<>();
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = " SELECT * FROM dataFC";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Card card = mapToCard(rs);
                list.add(card);
            }

            conn.close();
            return ok(Json.toJson(list));
        } catch (SQLException e) {
            e.printStackTrace();
            return ok("No Accessing");
        }
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result update() throws SQLException {
        try {
            JsonNode json = request().body().asJson();
            String kw = json.findPath("keyword").textValue();
            String cd = json.findPath("code").textValue();
            int idData = json.findPath("id").intValue();
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            String sql = "UPDATE dataFC SET keyword =" + '"' + kw + '"' + ", code = " + '"' + cd + '"' + " WHERE id =" + idData + "; ";
            st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ok();
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result saveData() throws SQLException {
        try {
            JsonNode json = request().body().asJson();

            String kw = json.findPath("keyword").textValue();
            String cd = json.findPath("code").textValue();

            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = " INSERT INTO dataFC ( keyword , code ) VALUES ( " + '"' + kw + '"' + " ," + '"' + cd + '"' + ")";
            stmt.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ok("saved");
    }

    public Result index() {
        return ok(views.html.index.render());
    }
}
