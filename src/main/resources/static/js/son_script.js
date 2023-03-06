const makeDiceNum = function () {

    const dice = {
        number: 0
    }

    $.ajax({
        type: "post",
        url: "son_dice",
        data: JSON.stringify(dice),
        contentType: "application/json",
        success: function (res) {
            dice.number = res.number;
            // console.log("성공", dice.number);
            rotateDice(dice);
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
