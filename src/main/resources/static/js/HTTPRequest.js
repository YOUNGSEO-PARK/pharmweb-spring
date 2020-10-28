$("#LoginBtn").on('click', () => { //.on 이벤트 트리거

    var selectVal = $("#login option:selected").val();

    if (selectVal == "user") {
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
                document.location.href = '/index';
            } else if (data.status == 103) {
                alert("유저 로그인 실패! 아이디와 비밀번호를 다시 입력해주세요!")
            }
        })
    }
    else if (selectVal == "pharmacist"){
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
                document.location.href = '/pharmacist';
            } else if (data.status == 203) {
                alert("약사 로그인 실패! 아이디와 비밀번호를 다시 입력해주세요!")
            }
        })
    }
    else if(selectVal == "rider"){
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
            url: "/api/ridlogin",
            data: JSON.stringify(data), //fix ; 객체->스트링
        }).done(function (data) {
            //로직 필요에 따라 변경
            if (data.status == 302) {
                alert("라이더님, 안녕하세요!")
                document.location.href = '/rider';
            } else if (data.status == 303) {
                alert("라이더 로그인 실패! 아이디와 비밀번호를 다시 입력해주세요!")
            }
        })
    }
})

$("#userDuplicateBtn").on('click', () => { //.on 이벤트 트리거
    console.log(data)

    if (check($("#user_id"))) {
        var data = {};
        $("form[name=regiform]").serializeArray().map(function (x) {
            data[x.name] = x.value;
        });
        console.log(data)

        $.ajax({
            type: "POST", //fix
            dataType: "json", //fix
            contentType: "application/json; charset=utf-8;", //fix
            url: "/api/udup",
            data: JSON.stringify(data), //fix ; 객체->스트링
        }).done(function (data) {

            //로직 필요에 따라 변경
            if (data.status == 100) {
                alert("사용 가능한 아이디입니다.")
            } else if (data.status == 101) {
                alert("이미 존재하는 아이디입니다. 아이디를 변경해주세요.")
            }
        })
    }
})

$("#pharmDuplicateBtn").on('click', () => { //.on 이벤트 트리거
    console.log(data)

    if (check($("#pharm_id"))) {
        var data = {};
        $("form[name=regiform]").serializeArray().map(function (x) {
            data[x.name] = x.value;
        });
        console.log(data)

        $.ajax({
            type: "POST", //fix
            dataType: "json", //fix
            contentType: "application/json; charset=utf-8;", //fix
            url: "/api/pdup",
            data: JSON.stringify(data), //fix ; 객체->스트링
        }).done(function (data) {

            //로직 필요에 따라 변경
            if (data.status == 200) {
                alert("사용 가능한 아이디입니다.")
            } else if (data.status == 201) {
                alert("이미 존재하는 아이디입니다. 아이디를 변경해주세요.")
            }
        })
    }
})

$("#riderDuplicateBtn").on('click', () => { //.on 이벤트 트리거
    console.log(data)

    if (check($("#rider_id"))) {
        var data = {};
        $("form[name=regiform]").serializeArray().map(function (x) {
            data[x.name] = x.value;
        });
        console.log(data)

        $.ajax({
            type: "POST", //fix
            dataType: "json", //fix
            contentType: "application/json; charset=utf-8;", //fix
            url: "/api/rdup",
            data: JSON.stringify(data), //fix ; 객체->스트링
        }).done(function (data) {

            //로직 필요에 따라 변경
            if (data.status == 300) {
                alert("사용 가능한 아이디입니다.")
            } else if (data.status == 301) {
                alert("이미 존재하는 아이디입니다. 아이디를 변경해주세요.")
            }
        })
    }
})

$("#userRegiBtn").on('click', () => { //.on 이벤트 트리거
    console.log(data)

    if (check($("#user_id"))) {
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
            data: JSON.stringify(data), //fix ; 객체->스트링
        }).done(function (data) {

            //로직 필요에 따라 변경
            if (data.status == 100) {
                alert("유저 회원가입 성공! 환영합니다!")
                document.location.href = '/index';
            } else if (data.status == 101) {
                alert("유저 회원가입 실패! 아이디 중복확인을 진행해주세요!")
            }
        })
    }
})

$("#pharmRegiBtn").on('click', () => { //.on 이벤트 트리거
    if (check($("#pharm_id"))) {
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
            data: JSON.stringify(data), //fix ; 객체->스트링
        }).done(function (data) {

            //로직 필요에 따라 변경
            if (data.status == 200) {
                alert("약사 회원가입 성공! 환영합니다!")
                document.location.href = '/pharmacist';
            } else if (data.status == 201) {
                alert("약사 회원가입 실패! 아이디와 비밀번호를 다시 입력해주세요!")
            }
        })
    }
})

$("#riderRegiBtn").on('click', () => { //.on 이벤트 트리거
    if (check($("#rider_id"))) {
        var data = {};
        $("form[name=regiform]").serializeArray().map(function (x) {
            data[x.name] = x.value;
        });
        console.log(data)

        $.ajax({
            type: "POST", //fix
            dataType: "json", //fix
            contentType: "application/json; charset=utf-8;", //fix
            url: "/api/rregi",
            data: JSON.stringify(data), //fix ; 객체->스트링
        }).done(function (data) {

            //로직 필요에 따라 변경
            if (data.status == 300) {
                alert("라이더 회원가입 성공! 환영합니다!")
                document.location.href = '/rider';
            } else if (data.status == 301) {
                alert("라이더 회원가입 실패! 아이디와 비밀번호를 다시 입력해주세요!")
            }
        })
    }
})

function check(str) {

    if (str.val() == '' || str.val() == null) {
        alert('값을 입력해주세요');
        return false;
    }

    var blank_pattern = /^\s+|\s+$/g;
    if (str.val().replace(blank_pattern, '') == "") {
        alert('공백만 입력되었습니다.');
        return false;
    }

    //공백 금지
    //var blank_pattern = /^\s+|\s+$/g;(/\s/g
    var blank_pattern = /[\s]/g;
    if (blank_pattern.test(str.val()) == true) {
        alert('공백은 사용할 수 없습니다.');
        return false;
    }

    var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;

    if (special_pattern.test(str.val()) == true) {
        alert('특수문자는 사용할 수 없습니다.');
        return false;
    }

    return true;

}

$("#userDeleteBtn").on('click', () => { //.on 이벤트 트리거
    let value = confirm("정말 탈퇴하시겠습니까?");

    if(value) {
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
            data: JSON.stringify(data), //fix ; 객체->스트링
        }).done(function (data) {
            //로직 필요에 따라 변경
            if (data.status == 400) {
                alert("회원탈퇴가 완료되었습니다. 이용해주셔서 감사합니다.")
                document.location.href = '/index';
            } else if (data.status == 401) {
                alert("비밀번호 입력 오류입니다. 비밀번호를 다시 입력해주세요.")
            }
        })
    }
})

//map
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

$("#orderBtn").on('click', () => { //.on 이벤트 트리거
    var data = {};
    $("form[name=orderform]").serializeArray().map(function (x) {
        data[x.name] = x.value;
    });
    console.log(data)

    $.ajax({
        type: "POST", //fix
        dataType: "json", //fix
        contentType: "application/json; charset=utf-8;", //fix
        url: "/api/insertorder",
        data: JSON.stringify(data), //fix ; 객체->스트링
    }).done(function (data) {

        //로직 필요에 따라 변경
        if (data.status == 600) {
            alert("주문 완료! 감사합니다!")
            document.location.href = '/thankyou';
        } else if (data.status == 601) {
            alert("주문 실패! 다시 시도해주세요.")
        }
    })
})

//------------------------------success-fin-------------------------------------------------------------------

$("#CartBtn").on('click', () => { //.on 이벤트 트리거
    var data = {};
    $("form[name=regiform]").serializeArray().map(function (x) {
        data[x.name] = x.value;
    });
    console.log(data)

    $.ajax({
        type: "POST", //fix
        dataType: "json", //fix
        contentType: "application/json; charset=utf-8;", //fix
        url: "/api/shop_single",
        data: JSON.stringify(data), //fix ; 객체->스트링
    }).done(function (data) {

        //로직 필요에 따라 변경
        if (data.status == 104) {
            alert("상품이 성공적으로 장바구니에 담겼습니다.")
            document.location.href = '/shop_single';
        } else if (data.status == 105) {
            alert("이미 장바구니에 있는 제품입니다.");
        } else if (data.status == 106) {
            alert("장바구니에 추가하지 못했습니다.");
        }
    })
})


