

const getDiceNum = function() {

    const dice = {
        last_number : 0,
        number: 0,
        id : ''
    }

    $.ajax({
        url: "tk108_dice",
        type : "post",
        data : JSON.stringify(dice),
        contentType: "application/json",

        success: function (data) {
            console.clear();
            console.group("success");
            console.debug("success(data) invoked.");
            console.log("1. data: ", data);
            dice.number = data.number;
            dice.last_number=data.last_number;

            rollingDice(dice);


            console.groupEnd();
        }, //success
        error: function (e) {
            console.log(e);
        }
    }); //.ajax
}

let degreeChange = 0;
const rollingDice = function ({last_number, number, id}) {
    console.log("last_ number : ",last_number);
    console.log("number : ",number);
    console.log("id : ",id);

    let arr= [[0,0,0],[0,90,0],[180,0,0],[0,270,0],[270,0,0],[90,0,0]]
    // 주사위를 가져옴
    const diceDivision = $(".dice");

    degreeChange = (degreeChange+360)%720;
    console.log(document.querySelector(".dice").style.transform = `rotateX(${arr[number-1][0]}) rotateY(${arr[number-1][1]}deg) rotateZ(${arr[number-1][2]}deg)`);
    document.querySelector(".dice").style.transform = `rotateX(${arr[number-1][0]+degreeChange}deg) rotateY(${arr[number-1][1]+degreeChange}deg) rotateZ(${arr[number-1][2]+degreeChange}deg)`;
}
