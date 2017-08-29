I,+++ Controller +++ //TODO - query Database

Create oject Connection for connecting to database Create oject Statement for sending statement SQL to database Create oject ResultSet for keeping data from database, allow you taking data Using ResultSet next() Using ResultSet next() -> return data in ResultSet mapToCard -> take data from database to java. // mapToCard

Connect to database, the same of queryDatabase Map data from ajax to controller Using Statement excuteUpdate to Insert data to database p/s: @!!! If you use "Insert" data from jquery to database, Value String = "+'"'++'"'+" Int = "++"

II,+++Models+++

Using class oject to map for controller

III,+++Views+++

Including: Js, css, html. html: views seeing by users .

css: decorate yours web js: ++$().on('click','', function(){ // My code Catch event of .

p/s: ( = "this") if you want to take "id" of Array, using ("var x = this.getAttribute("data-id") or x = $("").data("id")") }

Using ajax to query database from java Default: $.ajax(

{

type: "POST", Remembering that, medthod "POST" save data in ("body") if type is Json -> controller use JsonNode json = request().body().asJson(). json.findPath("field").textValue() -> taking data from input to java

url: "/save", Path in routes

contentType: "application/json; charset=utf-8",

data: JSON.stringify(jsonData),

dataType: 'json',

success: function(){ +Remembering that, Success hold on data of Action in routes. async: false } });

instead hide() = css('display','<type-display') " async: false " allow you using data in "success".