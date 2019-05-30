$(document).ready(function(){
    $('.nBtn, .table .eBtn').on('click', function(event){
        event.preventDefault();
        let href = $(this).attr('href');
        let text = $(this).text();

        if(text == 'Edit'){
            $.get(href, function(country){
                        alert('data return from server:'+ country);
                        $('.myForm #id').val(country.id);
                        $('.myForm #name').val(country.name);
                        $('.myForm #capital').val(country.capital);
                    });
            $('.myForm #exampleModal').modal();

        }else{
            $('.myForm #id').val('');
            $('.myForm #name').val('');
            $('.myForm #capital').val('');
            $('.myForm #exampleModal').modal();
        }



    });

    $('.delBtn').on('click', function(event){
        event.preventDefault();
        let href = $(this).attr('href');
        $('#myModal #delRef').attr('href');
        $('#myModal').modal();
    });

});