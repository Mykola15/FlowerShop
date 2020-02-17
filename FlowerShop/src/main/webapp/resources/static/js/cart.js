$(document).ready(function () {
    var total_price = 0;
    $.post("/price", function (data) {
        total_price = data;
        $(".price").text(total_price);
    });
    $('.minus-btn').click(function (e) {
        e.preventDefault();
        var $this = $(this);
        var $input = $this.closest('div').find('input');
        var value = parseInt($input.val());
        var item = $(e.target).parents(".item");
        var id = $(e.target).parents(".item").data("id");

        if (value > 1) {
            value = value - 1;
            $.post("/change_quantity", {value: value, id: id}, function (data) {
                total_price = data;
                $(".price").text(total_price);
            });
        } else {
            value = 0;
            $.post("/from_cart", {id: id}, function (data) {
                item.remove();
                total_price = data;
                $(".price").text(total_price);
            });
        }

        $input.val(value);
    });

    $('.plus-btn').click(function (e) {
        e.preventDefault();
        var $this = $(this);
        var $input = $this.closest('div').find('input');
        var value = parseInt($input.val());
        var id = $(e.target).parents(".item").data("id");
        if (value < 100) {
            value = value + 1;
        } else {
            value = 100;
        }
        $input.val(value);

        $.post("/change_quantity", {value: value, id: id}, function (data) {
            total_price = data;
            $(".price").text(total_price);
        });

    });


    $(".input").bind("change", function (event) {
        var id = $(event.target).parents(".item").data("id");
        var value = event.target.value;
        var item = $(event.target).parents(".item");


        if (value > 1) {
            $.post("/change_quantity", {value: value, id: id}, function (data) {
                total_price = data;
                $(".price").text(total_price);
            });
        } else {
            $.post("/from_cart", {id: id}, function (data) {
                item.remove();
                total_price = data;
                $(".price").text(total_price);
            });
        }
    });

    $('.delete-btn').on('click', function (event) {
        var item = $(event.target).parents(".item");
        $.post("/from_cart", {id: item.data("id")}, function (data) {
            item.remove();
            total_price = data;
            $(".price").text(total_price);
        });

    });
});
    