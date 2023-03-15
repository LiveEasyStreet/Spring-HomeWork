const makeDiceNum = function () {

    const diceForm = {
        number: 0,
        history: {
            1: 0,
            2: 0,
            3: 0,
            4: 0,
            5: 0,
            6: 0,
        }
    }

    $.ajax({
        type: "post",
        url: "son_dice",
        data: JSON.stringify(diceForm),
        contentType: "application/json",
        success: function (res) {
            rotateDice(res);
            // console.log(res.history);
        },
        error: function () {
            console.log("실패");
        }
    })
};

const rotateDice = function ({number, history}) {
    let diceNum = number;
    const diceDiv = $(".dice");

    setTimeout(() => {
        saveHistory(history);
    }, 3000);

    const btn = document.getElementById('diceButton');
    setTimeout(() => {
        btn.disabled = true;
    }, 0);
    setTimeout(() => {
        btn.disabled = false;
    }, 3000);

    diceDiv.removeClass("turn1 turn2 turn3 turn4 turn5 turn6");
    setTimeout(() => {
        diceDiv.toggleClass(`turn${diceNum}`);
    }, 0);
};

const saveHistory = function (history) {

    for (let key in history) {
        const value = history[key];
        const savedText = document.getElementById(`num${key}`).textContent;
        const span = $(`#num${key}`);
        if (savedText !== ` : ${value}번`) {
            $(`#num${key}`).css('color', 'red');
        } else {
            $(`#num${key}`).css('color', 'black');
        }

        span.text(` : ${value}번`);
    }
}

$(window).keydown((e) => {
    if (e.keyCode === 13 || e.which === 13) {
        makeDiceNum();
    }
});
