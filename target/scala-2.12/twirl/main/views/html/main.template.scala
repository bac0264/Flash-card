
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
* This template is called from the `index` template. This template
* handles the rendering of the page header and body tags. It takes
* two arguments, a `String` for the title of the page and an `Html`
* object to insert into the body of the page.
*/
  def apply/*7.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.32*/("""

"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        """),format.raw/*12.62*/("""
        """),format.raw/*13.9*/("""<title>"""),_display_(/*13.17*/title),format.raw/*13.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*14.54*/routes/*14.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*14.101*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*15.59*/routes/*15.65*/.Assets.versioned("images/favicon.png")),format.raw/*15.104*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*16.54*/routes/*16.60*/.Assets.versioned("stylesheets/bootstrap.min.css")),format.raw/*16.110*/("""">
        <meta http-equiv="Content-Security-Policy" content="default-src 'self' data: gap: https://ssl.gstatic.com 'unsafe-eval'; style-src 'self' 'unsafe-inline'; media-src *;**script-src 'self' http://onlineerp.solution.quebec 'unsafe-inline' 'unsafe-eval';** ">
    </head>
    <body>
        <script src=""""),_display_(/*20.23*/routes/*20.29*/.Assets.versioned("javascripts/jquery-3.2.1.min.js")),format.raw/*20.81*/(""""></script>
        """),format.raw/*21.84*/("""
        """),format.raw/*22.9*/("""<script src=""""),_display_(/*22.23*/routes/*22.29*/.Assets.versioned("javascripts/main2.js")),format.raw/*22.70*/(""""></script>
        <script src=""""),_display_(/*23.23*/routes/*23.29*/.Assets.versioned("javascripts/bootstrap.min.js")),format.raw/*23.78*/(""""></script>
        <div id="banner" >
            <button id="fc1">Category</button>
            <h2>My FlashCards</h2>
            <hr>
            <div id ="myfc">
                <h4>Add a Card</h4>
                <button id="addnew" >AddNew</button>
            </div>
        </div>
        <div id="input">
            KeyWord:<br>
            <textarea typeof ="text" id = "keyword" class="form-control"   placeholder="Some text..." rows="7"></textarea>
            <br>
            <br>
            Code:<br>
            <textarea typeof ="text" id = "code"  class="form-control"  placeholder="Some text..."  rows="10"></textarea>
            <button id ="saveData"><br>Save</button>
        </div>
        <div id ="count"></div>
        <div id="fc2">  <!-- display table all data -->
            <table id="table1">
                <tr>
                    <td>Edit</td>
                    <td>Key word</td>
                </tr>
            </table>
        </div>
        <div id="fc3">
            <div id = "fc3fake">
               <table id="table2">
                   <tr>
                       <td id ='tdData'></td>
                   </tr>
                </table>
                <button id="prev" >Prev</button>
                <button id="ok">Ok</button>
                <button id="flip" class="btn btn-success">Flip</button>
                <button id="next" >Next</button>
            </div>
            <div id="back1"><a  id ="back2"><<<<< Back</a> <hr></div>
        </div>
    </body>
    <div id = "footer"> © Develope by Bac Nguyen <hr></div>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Aug 18 08:24:01 ICT 2017
                  SOURCE: E:/GitRepo/flashcard/app/views/main.scala.html
                  HASH: 73a7479a462d6ae66584745bd106131563b92ec0
                  MATRIX: 1206->261|1331->291|1361->295|1444->403|1481->413|1516->421|1542->426|1632->489|1647->495|1710->536|1799->598|1814->604|1875->643|1959->700|1974->706|2046->756|2389->1072|2404->1078|2477->1130|2526->1226|2563->1236|2604->1250|2619->1256|2681->1297|2743->1332|2758->1338|2828->1387
                  LINES: 33->7|38->7|40->9|43->12|44->13|44->13|44->13|45->14|45->14|45->14|46->15|46->15|46->15|47->16|47->16|47->16|51->20|51->20|51->20|52->21|53->22|53->22|53->22|53->22|54->23|54->23|54->23
                  -- GENERATED --
              */
          