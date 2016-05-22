startTimers();

function startTimers() {
    t = setInterval(function () {
        showTime()
    }, 500);

    t2 = setInterval(function () {
        checkScroll()
    }, 500);
}

function showTime() {
    var dateObject = new Date();

    var datetime = dateObject.getDate() + "/"
        + (dateObject.getMonth() + 1) + "/"
        + dateObject.getFullYear() + " @ "
        + dateObject.getHours() + ":"
        + dateObject.getMinutes() + ":"
        + dateObject.getSeconds();

    document.getElementById("greeting").innerHTML = datetime;
}

/**
 * shows time in case scroll is not visible and scroll is at the bottom
 */
function checkScroll() {
    if ($(window).scrollTop() + $(window).height() == $(document).height()) {
        $(document.getElementById("greeting")).fadeIn();
    } else if ($(document).height() > $(window).height()) {
        $(document.getElementById("greeting")).fadeOut();
    } else {
        $(document.getElementById("greeting")).fadeIn();
    }
}


