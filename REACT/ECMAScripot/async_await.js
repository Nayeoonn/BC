
async function fetchData(){
    // fetch로 요청해서 받고 await로 응답 가능
    const response = await fetch("http://httpbin.org/get")
    // await를 쓰면 비동기 응답을 기다린다.
    console.log(response);
    // json 객체로 변환
    const data = await response.json()
    return data
    
    // response.then((result) => {
    //     console.log(result);
    // })
}

// await는 async 함수 안에서만 사용한다.

fetchData()
    .then((data) => {
        console.log(data);
    })
console.log("anync await 비동기 요청 처리")