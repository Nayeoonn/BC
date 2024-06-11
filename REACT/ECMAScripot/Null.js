let input       
// NULL일 때 대체값으로 홍길동이 들어감 그 역할 : ?? 이 해줌 
const nickname = input ?? '홍길동'  // NULL 병합
// const nickname = input
// if(input == null || input == undefined)
//      nickname = '홍길동'

if(nickname){
    console.log("이름이 있습니다.")
}

if(!nickname){
    console.log("이름이 없습니다.")
}
console.log(`이름 : ${nickname}`)