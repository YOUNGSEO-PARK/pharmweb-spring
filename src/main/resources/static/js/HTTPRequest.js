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
