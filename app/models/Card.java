package models;

import io.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by Bac on 8/1/2017.
 */
@Entity
public class Card extends Model{
    private String keyword;
    private String code;

    public Card(String keyword, String code) {
        this.keyword = keyword;
        this.code = code;
    }
    public Card(){
        this.keyword = "Bac";
        this.code = "DepTi";
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
