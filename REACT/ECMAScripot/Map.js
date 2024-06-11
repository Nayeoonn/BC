// Map 생성
const map = new Map()
map.set('김도희', '100점')
map.set('장원영', '90점')
map.set('김태희', '90점')
map.set('이영지', '1000점')

// get(key): 요소 가져오기
console.log(map);
console.log(map.get('김도희'));
console.log(map.get('장원영'));
console.log(map.get('김태희'));
console.log(map.get('이영지'));

// Map 초기화 생성
const map2 = new Map([
        ['조연진', '지각'],
        ['김슬기', '조퇴']
])

console.log("map2~~~~")
console.log(map2)

// map 반복
console.log("map 반복")
map.forEach((value, key, map) => {
    console.log(`${key}: ${value}`);
})

// map의 key 반복
console.log("map의 key 반복")
for( const key of map.keys() ) {
    console.log(key);
}

// map의 value 반복
console.log("map의 value 반복")
for( const value of map.values() ) {
    console.log(value);
}