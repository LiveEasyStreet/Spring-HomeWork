

const getDiceNum = function() {

    const dice = {
        number: [0,0,0,0,0]
    }

    $.ajax({
        url: "tk108_dice",
        type : "post",
        data : JSON.stringify(dice),
        contentType: "application/json",

        success: function (data) {
            console.clear();
            console.group("success");
            console.log(data);
            console.debug("success(data) invoked.");
            console.log("1. data: ", data);
            // dice.number[0] = data.number[0];
            // dice.number[1] = data.number[1];
            // dice.number[2] = data.number[2];
            // dice.number[3] = data.number[3];
            // dice.number[4] = data.number[4];

            dice.number[0] = data.history[0].number[0];
            dice.number[1] = data.history[0].number[1];
            dice.number[2] = data.history[0].number[2];
            dice.number[3] = data.history[0].number[3];
            dice.number[4] = data.history[0].number[4];

            rollingDice(dice);
            console.log("temporary : ",temporary_data);


            console.groupEnd();
        }, //success
        error: function (e) {
            console.log(e);
        }
    }); //.ajax
}

const temporary_data = {number: [0,0,0,0,0]};
let degreeChange = 0;
const rollingDice = function ({number}) {
    console.log("number : ",number);
    temporary_data.number[0] = number[0];
    temporary_data.number[1] = number[1];
    temporary_data.number[2] = number[2];
    temporary_data.number[3] = number[3];
    temporary_data.number[4] = number[4];

    let arr= [[0,0,0],[0,90,0],[180,0,0],[0,270,0],[270,0,0],[90,0,0]]
    // 주사위를 가져옴
    const diceDivision = $(".dice");

    const btn = document.getElementById('rolling_button');
    const btn2 = document.getElementById('save_button');
    btn2.disabled = false;
    setTimeout(() => {
        btn.disabled = true;
    }, 0);
    setTimeout(() => {
        btn.disabled = false;
    }, 1800);

    console.log(diceDivision.length);
    degreeChange = (degreeChange+360)%720;
    for(let i =0; i<diceDivision.length;i++) {
        // console.log("before : ",document.querySelectorAll(".dice")[i].style.transform);
        document.querySelectorAll(".dice")[i].style.transform = `rotateX(${arr[number[i] - 1][0] + degreeChange}deg) rotateY(${arr[number[i] - 1][1] + degreeChange}deg) rotateZ(${arr[number[i] - 1][2] + degreeChange}deg)`;
        // console.log("after : ",document.querySelectorAll(".dice")[i].style.transform);
    }

}

const saveDice = function (){

    const btn2 = document.getElementById('save_button');
    btn2.disabled = true;

    $.ajax({
        url: "tk108_dice",
        type : "post",
        data : JSON.stringify(temporary_data),
        contentType: "application/json",

        success: function (data) {
            console.clear();
            console.group("success");
            console.log(data);
            console.debug("success(data) invoked.");
            console.log("1. data: ", data);
            // console.log("2. data: ", data.history[0]);
            let data_len = Object.keys(data.history).length;
            console.log(data_len);
            const result_list = document.getElementById("result_list");
            console.log("result : ",result_list.innerHTML);
            let div_table = document.createElement("div");
            if(data_len>5){
                for(let i=data_len-1;i>=data_len-5;i--){
                    let p_table = document.createElement("p");
                    for(let j=0;j<5;j++){
                        const icon = document.createElement("i");
                        if(data.history[i].number[j]==1){
                            icon.setAttribute("class","fa-solid fa-dice-one");
                        }
                        else if(data.history[i].number[j]==2){
                            icon.setAttribute("class","fa-solid fa-dice-two");
                        }
                        else if(data.history[i].number[j]==3){
                            icon.setAttribute("class","fa-solid fa-dice-three");
                        }
                        else if(data.history[i].number[j]==4){
                            icon.setAttribute("class","fa-solid fa-dice-four");
                        }
                        else if(data.history[i].number[j]==5){
                            icon.setAttribute("class","fa-solid fa-dice-five");
                        }
                        else if(data.history[i].number[j]==6){
                            icon.setAttribute("class","fa-solid fa-dice-six");
                        }
                        p_table.appendChild(icon);
                    }
                    div_table.appendChild(p_table);
                }
            }
            else{
                for (let i=data_len-1;i>0;i--){
                    let p_table = document.createElement("p");
                    for(let j=0;j<5;j++){
                        const icon = document.createElement("i");
                        if(data.history[i].number[j]==1){
                            icon.setAttribute("class","fa-solid fa-dice-one");
                        }
                        else if(data.history[i].number[j]==2){
                            icon.setAttribute("class","fa-solid fa-dice-two");
                        }
                        else if(data.history[i].number[j]==3){
                            icon.setAttribute("class","fa-solid fa-dice-three");
                        }
                        else if(data.history[i].number[j]==4){
                            icon.setAttribute("class","fa-solid fa-dice-four");
                        }
                        else if(data.history[i].number[j]==5){
                            icon.setAttribute("class","fa-solid fa-dice-five");
                        }
                        else if(data.history[i].number[j]==6){
                            icon.setAttribute("class","fa-solid fa-dice-six");
                        }
                        p_table.appendChild(icon);
                    }
                    div_table.appendChild(p_table);
                }
            }   //else

            result_list.innerHTML="";
            result_list.appendChild(div_table);

            console.groupEnd();
        }, //success
        error: function (e) {
            console.log(e);
        }
    }); //.ajax
    // {
    //     // 새로운 테이블 생성
    //     let tbl = $("<table>");
    //
    //     // 새로 생성한 <table> 태그에 신규 속성 추가 및 스타일 적용
    //     tbl.attr("border", 1).css({
    //         border: "1px solid black",
    //         // 경계선 붙이라는 의미
    //         borderCollapse: "collapse",
    //     });
    //
    //     $(".result_list").append($("<p>").text(temporary_data).css("padding-left", "10px"));
    // }

}
