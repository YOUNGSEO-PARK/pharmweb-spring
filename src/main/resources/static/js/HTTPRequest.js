$("#userLoginBtn").on('click',()=>{ //.on 이벤트 트리거
    var data = {};
    //loginform 태그에 접근 후 직렬화 후 객체화
    $("form[name=loginform]").serializeArray().map(function(x){data[x.name] = x.value;});
    console.log(data)

    $.ajax({
        type: "POST", //fix
        dataType: "json", //fix
        contentType: "application/json; charset=utf-8;", //fix
        url: "/api/uidlogin",
        data: JSON.stringify(data), //fix ; 객체->스트링
    }).done(function(data) {
        //로직 필요에 따라 변경
        if(data.status==200){
            alert("안녕하세요, 기운팜팜입니다!")
            document.location.href = '/';
        }
        else if(data.status==400){
            alert("유저 로그인 실패! 아이디와 비밀번호를 다시 입력해주세요!")
        }
    })
})

$("#pharmLoginBtn").on('click',()=>{ //.on 이벤트 트리거
    var data = {};
    //loginform 태그에 접근 후 직렬화 후 객체화
    $("form[name=loginform]").serializeArray().map(function(x){data[x.name] = x.value;});
    console.log(data)

    $.ajax({
        type: "POST", //fix
        dataType: "json", //fix
        contentType: "application/json; charset=utf-8;", //fix
        url: "/api/pidlogin",
        data: JSON.stringify(data), //fix ; 객체->스트링
    }).done(function(data) {
        //로직 필요에 따라 변경
        if(data.status==200){
            alert("약사님, 안녕하세요!")
            document.location.href = '/';
        }
        else if(data.status==400){
            alert("약사 로그인 실패! 아이디와 비밀번호를 다시 입력해주세요!")
        }
    })
})

$("#userRegiBtn").on('click',()=>{ //.on 이벤트 트리거
    var data = {};
    $("form[name=regiform]").serializeArray().map(function(x){data[x.name] = x.value;});
    console.log(data)

    $.ajax({
        type: "POST", //fix
        dataType: "json", //fix
        contentType: "application/json; charset=utf-8;", //fix
        url: "/api/uregi",
        data: JSON.stringify(data), //fix ; 객체->트링
    }).done(function(data) {
        //로직 필요에 따라 변경
        if(data.status==200){
            alert("유저 회원가입 성공! 환영합니다!")
            document.location.href = '/';
        }
        else if(data.status==400){
            alert("이미 존재하는 아이디입니다. 아이디와 비밀번호를 다시 입력해주세요!")
        }
    })
})


// $("#pharmRegiBtn").on('click',()=>{ //.on 이벤트 트리거
//     var data = {};
//     $("form[name=regiform]").serializeArray().map(function(x){data[x.name] = x.value;});
//     console.log(data)
//
//     $.ajax({
//         type: "POST", //fix
//         dataType: "json", //fix
//         contentType: "application/json; charset=utf-8;", //fix
//         url: "/api/pregi",
//         data: JSON.stringify(data), //fix ; 객체->트링
//     }).done(function(data) {
//         //로직 필요에 따라 변경
//         if(data.status==200){
//             alert("약사 회원가입 성공! 환영합니다!")
//             document.location.href = '/';
//         }
//         else if(data.status==400){
//             alert("이미 존재하는 약국입니다. 아이디와 비밀번호를 다시 입력해주세요!")
//         }
//     })
// })

$("#userDeleteBtn").on('click',()=>{ //.on 이벤트 트리거
    var data = {};
    $("form[name=deleteform]").serializeArray().map(function(x){data[x.name] = x.value;});
    console.log(data)

    $.ajax({
        type: "POST", //fix
        dataType: "json", //fix
        contentType: "application/json; charset=utf-8;", //fix
        url: "/api/udelete",
        data: JSON.stringify(data), //fix ; 객체->트링
    }).done(function(data) {
        //로직 필요에 따라 변경
        if(data.status==200){
            alert("유저 회원탈퇴가 완료되었습니다. 이용해주셔서 감사합니다.")
            document.location.href = '/';
        }
        else if(data.status==400){
            alert("존재하지 않는 아이디입니다. 아이디와 비밀번호를 다시 입력해주세요.")
        }
    })
})
/*
$('input[type=button]').click(function(){
    $.ajax({
        url : './location',
        type : 'GET',
        dataType : 'json',
        success : function(data){
            const list = data.list;
            let txt;

            $.each(list, function(index, data){
                //data === list[i]
                txt += `<tr>
                <td>${data.wgs84Lat}</td>
                <td>${data.wgs84Lon}</td>
                </tr>`;
            });

            $('table').html(txt);
        }
    });
});*/


var myCommon = {};
myCommon.util = {
    // method : get/post , url : call url
    // params    : json 형식 요청 데이터, callbackFunction : callback 함수명
    callAjax : function(method, url, type,params, callbackFunction ){
        if(method=="" || url==""){
            console.log("method or url empty");
            return false;
        }

        $.ajax({
            type : method
            , url : url
            , data : JSON.stringify(params)
            , contentType:'application/json; charset=utf-8'
            , dataType: type
            , success : function(response) {
                if (type == "html") {
                    $(document.getElementById(callbackFunction)).html(response);
                } else {
                    // Callback 함수 호출
                    if (typeof(callbackFunction) == "function")
                        callbackFunction(params, response);
                }
            }
            , error : function(jqXHR, error) {
                console.log(error);
            }
        });
    }
};
/*
function Getloc() {
    //$("#loc-btn").click(function () {
        var position = {
            wgs84Lat: $("#wgs84Lat").val(),
            wgs84Lon: $("#wgs84Lon").val()
        };
        $.ajax({
            url: "/location",
            data: position,
            type: "get",
            dataType: "json",
            async: false,
            success: function (data) {
                alert("success");
                return data;
            },

            error: function () {
                alert("error");
            }
        });
    };*/