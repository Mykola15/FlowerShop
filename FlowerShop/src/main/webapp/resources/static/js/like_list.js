$(document).ready(function () {

    $('.delete-btn').on('click', function (event) {
        var item = $(event.target).parents(".item");
        $.post("/from_like_list", {id: item.data("id")},function () {
         item.remove();
        });
    });
});