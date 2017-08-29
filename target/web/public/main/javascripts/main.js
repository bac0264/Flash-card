/**
 * Created by Bac on 6/20/2017.
 */
var front = false;
var index = 0;
var myFlashCards = [];
var marked = [];
var content = 0;
var data = $.parseJSON($.ajax({
    type: "POST",
    url: "/query", /*
     success: function(data){}
     ,*/
    async: false
}).responseText);
for (var i1 = 0; i1 <= data.length - 1; i1++) {
    myFlashCards.push(data[i1]);
}
//for (var i2 =1; i2 <= myFlashCards.length-1; i2++){
//   if (myFlashCards[0].keyword == myFlashCards[i2].keyword){
//       myFlashCards.splicedsd(i2,myFlashCards.length-1);
//   }
//}


$(document).ready(function () {
    $("#fc2").show(printData());
    $("#input").hide();
    $("#count").show(printAmount());
    $("#addnew").click(function () {
        $("#fc3").hide();
        $("#fc2").hide();
        $("#count").hide();
        $("#input").toggle();
    });
    $("#fc1").click(function () {
        $("#input").hide();
        $("#fc3").hide();
        $("#fc2").show(printData());
        $("#count").show();
    });
    $("#fc3").hide();
    // $("#edit").click(editFC());
    $('#table1').on('click', '#idd', function () {
        $("#fc2").css('display', 'none');
        var x = this.getAttribute('data-id');
        index = x;
        function td() {
            front = true;
            $("#tdData").html(myFlashCards[x].keyword);
        }

        $("#fc3").css('display', 'block', td());

    });

    var btnBack = $("#back1");

    btnBack.click(function () {
        //  $("#tdData").empty();
        $("#fc3").css('display', 'none');
        $("#fc2").css('display', 'block', printData());
    });
    $("#saveData").click(function () {
        var jsonData = {"keyword": $("#keyword").val(), "code": $("#code").val()};
        if (jsonData.keyword != "") {
            $.ajax({
                type: "POST",
                url: "/save",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(jsonData),
                dataType: 'json',
                success: function () {
                }
            });
            myFlashCards.push(jsonData);
        }
        $("textarea").val("");
        $("#input").hide();
        $("#fc2").show(printData());
    });
});
$(document).ready(function () {
    $('#table1').on('click', '#edit', function () {

        $("#fc2").css('display', 'none');
        var butt = this.getAttribute('data-card');
        index = butt;

        //  $("#table2").html("<tr class='key'><th>KeyWord</th></tr>" + "<tr><th>" + myFlashCards[x].keyword + "</th></tr>");
        function td() {
            front = true;
            $('#tdData').html(myFlashCards[butt].keyword);

        }

        $('#tdData').attr('contentEditable', true);
        $("#fc3").css('display', 'block', td());
    });
    $(document).ready(function () {
        $("#ok").click(function () {
            if (front == true) {
                var a = $("#tdData").text();
                myFlashCards[index].keyword = a;
                marked[index] = -1;
                console.log(a);
            }
            else {
                var b = $("#tdData").text();
                myFlashCards[index].code = b;
                marked[index] = -1;
                console.log(b);
            }
            var indexReal = ++index;
            var jsonD = {"keyword": myFlashCards[--index].keyword, "code": myFlashCards[index].code, "id": indexReal};
            $.ajax({
                type: "POST",
                url: "updateData",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(jsonD),
                dataType: 'json',
                success: function () {
                }
            });
            console.log(jsonD);
        });
    });
});

function printAmount() {
    var count = 0;
    for (var i = 0; i < myFlashCards.length; i++) count++;
    $("#count").append("<h1> " + count + " Card(s)</h1>");
}
function printData() {
    for (var i = 0; i < myFlashCards.length; i++) {
        // $("#print").html(myFlashCards[i].code +" - "+ myFlashCards[i].keyword);
        if (marked[i] != i) //$("#print").append("<p>"+myFlashCards[i].code +" - "+ myFlashCards[i].keyword+"</p>");
        {
            if (marked[i] == -1) {
                $('[data-id="' + i + '"]').html(myFlashCards[i].keyword);
                marked[i] = i;
            }
            else {
                $("#table1").append("<tr ><td><button class ='btn btn-success' id ='edit' data-card=" + i + " ><span class ='glyphicon glyphicon-pencil'></span></button></td><td id ='idd'  data-id =" + i + "  width ='100%'>" + myFlashCards[i].keyword + "</td></tr><br>");
                marked.push(i);
            }
        }


    }
}

function nextFC() {
    if (index >= myFlashCards.length - 1) {
        alert("Admin says: \nMax");
    }
    else {
        index++;
        $("#fc3").show(function () {
            $("#tdData").html(myFlashCards[index].keyword);
        });
    }
}
function prevFC() {
    if (index <= 0) {
        alert("Admin says: \nMin");
    }
    else {
        index--;
        $("#fc3").show(function () {
            $("#tdData").html(myFlashCards[index].keyword);
        });

    }
}
function flipFC() {
    if (!front) {
        front = true;
        $("#fc3").show(function () {
            $("#tdData").html(myFlashCards[index].keyword);
        });
        content = 0;
    }
    else {
        front = false;
        $("#fc3").show(function () {
            $("#tdData").html(myFlashCards[index].code);
        });
        content = 1;
    }
}
//function okFC(){
// var x =
//}
document.addEventListener('DOMContentLoaded', function () {
    var link1 = document.getElementById('prev');
    var link2 = document.getElementById('flip');
    var link3 = document.getElementById('next');
    link1.addEventListener('click', prevFC);
    link2.addEventListener('click', flipFC);
    link3.addEventListener('click', nextFC);
});

