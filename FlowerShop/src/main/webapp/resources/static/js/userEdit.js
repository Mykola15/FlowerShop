$(document).ready(function () {
    $('.delete-btn').on('click', function (event) {
        var id = $(event.target).data("id");
        $.post("/delete_user", {id:id},function (){
            location.href="http://localhost:8080/users";
        });
    });
});