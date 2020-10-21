$("#userLoginBtn").on('click', () => { //.on 이벤트 트리거
    var data = {};
    //loginform 태그에 접근 후 직렬화 후 객체화
    $("form[name=loginform]").serializeArray().map(function (x) {
        data[x.name] = x.value;
    });
    console.log(data)

    $.ajax({
        type: "POST", //fix
        dataType: "json", //fix
        contentType: "application/json; charset=utf-8;", //fix
        url: "/api/uidlogin",
        data: JSON.stringify(data), //fix ; 객체->스트링
    }).done(function (data) {
        //로직 필요에 따라 변경
        if (data.status == 102) {
            alert("안녕하세요, 기운팜팜입니다!")
            document.location.href = '/api/session';
        } else if (data.status == 103) {
            alert("유저 로그인 실패! 아이디와 비밀번호를 다시 입력해주세요!")
        }
    })
})

$("#pharmLoginBtn").on('click', () => { //.on 이벤트 트리거
    var data = {};
    //loginform 태그에 접근 후 직렬화 후 객체화
    $("form[name=loginform]").serializeArray().map(function (x) {
        data[x.name] = x.value;
    });
    console.log(data)

    $.ajax({
        type: "POST", //fix
        dataType: "json", //fix
        contentType: "application/json; charset=utf-8;", //fix
        url: "/api/pidlogin",
        data: JSON.stringify(data), //fix ; 객체->스트링
    }).done(function (data) {
        //로직 필요에 따라 변경
        if (data.status == 202) {
            alert("약사님, 안녕하세요!")
            document.location.href = '/api/session';
        } else if (data.status == 203) {
            alert("약사 로그인 실패! 아이디와 비밀번호를 다시 입력해주세요!")
        }
    })
})


$("#userRegiBtn").on('click', () => { //.on 이벤트 트리거

    if (check()) {
        var data = {};
        $("form[name=regiform]").serializeArray().map(function (x) {
            data[x.name] = x.value;
        });
        console.log(data)

        $.ajax({
            type: "POST", //fix
            dataType: "json", //fix
            contentType: "application/json; charset=utf-8;", //fix
            url: "/api/uregi",
            data: JSON.stringify(data), //fix ; 객체->트링
        }).done(function (data) {

            //로직 필요에 따라 변경
            if (data.status == 100) {
                alert("유저 회원가입 성공! 환영합니다!")
                document.location.href = '/';
            } else if (data.status == 101) {
                alert("유저 회원가입 실패! 아이디와 비밀번호를 다시 입력해주세요!")
            }
        })
    }

})

function check() {

    var str = $("#user_id")

    if (str.val() == '' || str.val() == null) {
        alert('값을 입력해주세요');
        return false;
    }

    var blank_pattern = /^\s+|\s+$/g;
    if (str.val().replace(blank_pattern, '') == "") {
        alert(' 공백만 입력되었습니다 ');
        return false;
    }

    //공백 금지
    //var blank_pattern = /^\s+|\s+$/g;(/\s/g
    var blank_pattern = /[\s]/g;
    if (blank_pattern.test(str.val()) == true) {
        alert(' 공백은 사용할 수 없습니다. ');
        return false;
    }

    var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;

    if (special_pattern.test(str.val()) == true) {
        alert('특수문자는 사용할 수 없습니다.');
        return false;
    }

    /*
    if( str.value.search(/\W|\s/g) > -1 ){
        alert( '특수문자 또는 공백을 입력할 수 없습니다.' );
        str.focus();
        return false;
    }*/

}


//------------------------------success-fin-------------------------------------------------------------------

// $("#LoginBtn").on('click', () => { //.on 이벤트 트리거
//
//     $("input[name='login']:radio").change(function () {
//         var serviceType = this.value;
//
//         if (login == "user") {
//             var data = {};
//             //loginform 태그에 접근 후 직렬화 후 객체화
//             $("form[name=loginform]").serializeArray().map(function (x) {
//                 data[x.name] = x.value;
//             });
//             console.log(data)
//
//             $.ajax({
//                 type: "POST", //fix
//                 dataType: "json", //fix
//                 contentType: "application/json; charset=utf-8;", //fix
//                 url: "/api/midlogin",
//                 data: JSON.stringify(data), //fix ; 객체->스트링
//             }).done(function (data) {
//                 //로직 필요에 따라 변경
//                 if (data.status == 402) {
//                     alert("안녕하세요, 기운팜팜입니다!")
//                     document.location.href = '/api/session';
//                 } else if (data.status == 403) {
//                     alert("유저 로그인 실패! 아이디와 비밀번호를 다시 입력해주세요!")
//                 }
//             })
//         }
//     })
// })

$("#pharmRegiBtn").on('click', () => { //.on 이벤트 트리거
    var data = {};
    $("form[name=regiform]").serializeArray().map(function (x) {
        data[x.name] = x.value;
    });
    console.log(data)

    $.ajax({
        type: "POST", //fix
        dataType: "json", //fix
        contentType: "application/json; charset=utf-8;", //fix
        url: "/api/pregi",
        data: JSON.stringify(data), //fix ; 객체->트링
    }).done(function (data) {

        //로직 필요에 따라 변경
        if (data.status == 200) {
            alert("약사 회원가입 성공! 환영합니다!")
            document.location.href = '/';
        } else if (data.status == 201) {
            alert("약사 회원가입 실패! 아이디와 비밀번호를 다시 입력해주세요!")
        }
    })
})

$("#userDeleteBtn").on('click', () => { //.on 이벤트 트리거
    var data = {};
    $("form[name=deleteform]").serializeArray().map(function (x) {
        data[x.name] = x.value;
    });
    console.log(data)

    $.ajax({
        type: "POST", //fix
        dataType: "json", //fix
        contentType: "application/json; charset=utf-8;", //fix
        url: "/api/udelete",
        data: JSON.stringify(data), //fix ; 객체->트링
    }).done(function (data) {
        //로직 필요에 따라 변경
        if (data.status == 200) {
            alert("유저 회원탈퇴가 완료되었습니다. 이용해주셔서 감사합니다.")
            document.location.href = '/';
        } else if (data.status == 400) {
            alert("존재하지 않는 아이디입니다. 아이디와 비밀번호를 다시 입력해주세요.")
        }
    })
})
