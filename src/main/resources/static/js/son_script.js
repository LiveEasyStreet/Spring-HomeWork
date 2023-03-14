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
            console.log(res.history);
        },
        error: function () {
            console.log("실패");
        }
    })
};

const rotateDice = function ({number}) {
    let diceNum = number;
    const diceDiv = $(".dice");
    diceDiv.removeClass("turn1 turn2 turn3 turn4 turn5 turn6");
    setTimeout(() => {
        diceDiv.toggleClass(`turn${diceNum}`);
    }, 0);
};

$(window).keydown((e) => {
    if (e.keyCode === 13 || e.which === 13) {
        makeDiceNum();
    }
});
