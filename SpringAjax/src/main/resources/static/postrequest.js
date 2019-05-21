$(document).ready(
    function (){
        //SUBMIT FORM
        $("#bookForm").submit(function(event){
            //Prevent the from from submitting via the browser.
            event.preventDefault();
            ajaxPost();
        });

        function ajaxPost(){

            //PREPARE FROM DATA
            var formData = {
                bookId: $("#bookId").val(),
                bookName: $("#bookName").val(),
                author: $("#author").val()
            };

            //DO POST

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url : window.location + "addBook",
                data : JSON.stringify(formData),
                dataType : 'json',
                success : function(result){
                    if(result.status =="success"){
                        $("#postResultDiv").html(
                            ""+result.data.bookName
                                +"Post successfully! <br>"
                                +" ---> Congrats!"
                                +"</p>"
                        );
                    }else{
                        $("#postResultDiv").html("<strong>error</strong>");
                    }
                    console.log(result);
                },
                error : function(e){
                    alert("error");
                    console.log("Error: ", e);
                }
            });

        }

    }
);