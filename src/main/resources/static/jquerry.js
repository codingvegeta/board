const URL = 'http://localhost:8080'

// function getMemberList() {
//     $.ajax({
//         url: "list.jsp",                    //list.jsp에 AJAX요청
//         success: function (data) {
//             let obj = JSON.parse(data);      //data를 받아와서 JSON형태로 변환
//             let array = ["<ol>"];
//             obj["member_list"].forEach(
//                 member => array.push("<li>" + member.id + "</li>")
//                 //JSON에 있는 member.id의 value를 li태그에 넣어서 array에 넣어줌
//             );
//             array.push("</ol>");
//
//             $("#result").html(array.join(""));
//             //array의 요소들을 다 합쳐서 하나로 만든후 id="result"인 태그에 html로 출력
//         }
//     });
// }
//
// $.ajax({
//     type: 'post',           // 타입 (get, post, put 등등)
//     url: '/test',           // 요청할 서버url
//     async: true,            // 비동기화 여부 (default : true)
//     headers: {              // Http header
//         "Content-Type": "application/json",
//         "X-HTTP-Method-Override": "POST"
//     },
//     dataType: 'text',       // 데이터 타입 (html, xml, json, text 등등)
//     data: JSON.stringify({  // 보낼 데이터 (Object , String, Array)
//         "no": no,
//         "name": name,
//         "nick": nick
//     }),
//     success: function (result) { // 결과 성공 콜백함수
//         console.log(result);
//     },
//     error: function (request, status, error) { // 결과 에러 콜백함수
//         console.log(error)
//     }
// })

function postProtocol(url, data, successCallBack, failedCallBack) {
    $.ajax({
        type: 'post',
        url: url,
        contentType : "application/json",
        data: data,
        success: function (result) {
            console.log(result);
            successCallBack(result);
        },
        error: function (request, status, err) {
            console.log(request);
            console.log(status);
            console.log(err);
            failedCallBack(err);
        },
    })
}