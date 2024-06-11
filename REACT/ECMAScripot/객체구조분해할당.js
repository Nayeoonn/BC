const person={
    name    : 'hi',
    age     : 25,
    gender  : '남자'
}

// 객체의 구조 분해 할당
// rest를 꼭 쓸 필요는 없음 (name, age만 쓸거면)
// person 안에 있는걸 꺼내서 name, age 를 가져옴
const {name, age, ...rest} = person

console.log(name);
console.log(age);
console.log(rest);
