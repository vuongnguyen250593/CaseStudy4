function getValue() {
    let a = document.getElementsByClassName("range-price").item(1)
    let b = jQuery(this).data('value-min')
    let c = jQuery(this).data('value-max')
    $('.slider-range-price').each(function () {
        var min = jQuery(this).data('min');
        var max = jQuery(this).data('max');
        var unit = jQuery(this).data('unit');
        var value_min = jQuery(this).data('value-min');
        var value_max = jQuery(this).data('value-max');
        var label_result = jQuery(this).data('label-result');
        var t = $(this);
        $(this).slider({
            range: true,
            min: min,
            max: max,
            values: [value_min, value_max],
            slide: function (event, ui) {
                var result = label_result + " " + unit + ui.values[0] + ' - ' + unit + ui.values[1];
                console.log(t);
                t.closest('.slider-range').find('.range-price').html(result);
            }
        });
        console.log(min)
        console.log(max)
        console.log(value_max)
        console.log(value_min)
        console.log(unit)
        console.log(label_result)
    });
    console.log(a)
    console.log(b)
    console.log(c)
}