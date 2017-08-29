/**
 * Created by Bac on 8/18/2017.
 */

var front = false;
var index = 0;
var myFlashCards = [];
var marked = [];
var content = 0;

$(document).ready(function () {
    fcData();
    console.log(myFlashCards);

    $("#table1").on('click', function () {
        console.log(myFlashCards);
    });

});


/*Query flashcard from database*/
var fcData = function () {
    $.ajax({
        type: "POST",
        url: "/query",
        success: function (data) {
            printData(data);
            myFlashCards = data;
        }
    });
};

function printData(cards) {
    for (var i = 0; i < cards.length; i++) {
        if (marked[i] != i) {
            if (marked[i] == -1) {
                $('[data-id="' + i + '"]').html(cards[i].keyword);
                marked[i] = i;
            }
            else {
                $("#table1").append("<tr ><td><button class ='btn btn-success' id ='edit' data-card="
                    + i + " ><span class ='glyphicon glyphicon-pencil'></span></button></td><td id ='idd'  data-id ="
                    + i + "  width ='100%'>" + cards[i].keyword + "</td></tr><br>");
                marked.push(i);
            }
        }
    }
}