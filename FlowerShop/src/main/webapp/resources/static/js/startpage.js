$(document).ready(function () {

    $('.minus-btn').click(function (e) {
        e.preventDefault();
        var $this = $(this);
        var $input = $this.closest('div').find('input');
        var value = parseInt($input.val());

        if (value > 1) {
            value = value - 1;
        } else {
            value = 0;
        }

        $input.val(value);

    });

    $('.plus-btn').click(function (e) {
        e.preventDefault();
        var $this = $(this);
        var $input = $this.closest('div').find('input');
        var value = parseInt($input.val());

        if (value < 101) {
            value = value + 1;
        } else {
            value = 101;
        }
        $input.val(value);
    });


    $('.like-btn').on('click', function (event) {
        var value = 0;

        $(this).toggleClass('is-active');
        if ($(event.target).hasClass("is-active")) {
            value = 1;
        }
        var id = $(event.target).parents(".good-item").data("id");
        $.post("/to_like_list", {id: id, value: value});


    });
});