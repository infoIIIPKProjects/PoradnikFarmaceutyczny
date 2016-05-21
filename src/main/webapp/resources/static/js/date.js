startTime()

function startTime() {
    var dateObject = new Date();

    var datetime = dateObject.getDate() + "/"
        + (dateObject.getMonth() + 1) + "/"
        + dateObject.getFullYear() + " @ "
        + dateObject.getHours() + ":"
        + dateObject.getMinutes() + ":"
        + dateObject.getSeconds();

    document.getElementById("greeting").innerHTML = datetime;

    t = setTimeout(function () {
        startTime()
    }, 500);

    t2 = setTimeout(function () {
        checkScroll()
    }, 500);
}

function checkScroll() {
    if ($(window).scrollTop() + $(window).height() == $(document).height()) {
        $(document.getElementById("greeting")).fadeIn();
    } else if ( $(document).height() > $(window).height()) {
        $(document.getElementById("greeting")).fadeOut();
    } else {
        $(document.getElementById("greeting")).fadeIn();
    }
}


