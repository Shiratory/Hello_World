/**
 * object.js
 */
console.log("start");

// dom제어
let li = document.createElement('li'); // 새로운요소 생성
li.innerText = 'cherry'; // <li>cherry</li>

document.querySelector('ul#list').appendChild(li); // 자식놈 추가
document.querySelector('ul#list').style.display = 'none';




let name = "뷁"; // 값이 할당되는 시점에 type 정해짐
let num = 24235; // 값이 할당되는 시점에 type 정해짐
console.log(typeof name);
console.log(typeof num);

const obj = {
	name: "김두한",
	age : 55,
	friends: ['박진영', '조병옥', '시라소니'],
	pets: [{name:'심영', age:45}, {name:'상하이조', age:32}] 
}
obj.height = 19721121.1;

console.log(typeof obj);
console.log(obj.name, obj["age"]);
console.log('첫번째 친구', obj['friends'][0])
console.log('첫번째 동물 이름', obj.pets[0].name)
// 신익희 추가
obj.friends[2] = '신익희';
// 친구 목록
for(let i = 0; i <obj.friends.length; i++){
	console.log('친구이름 : ', obj.friends[i])
}
// 신불출 추가
obj.pets.push({name : '신불출', age: 40});
// 애완동물 목록 화면출력
// <table><thead><tr><th/></tr></thead><tbody>...</tbody></table>
let tblHtml = '<table class = "table">';
tblHtml += '<thead><tr><th>이름</th><th>나이</th></tr></thead>';
tblHtml += '<tbody>';
for(let pet of obj.pets){
	console.log(`동물이름 ${pet.name}, 나이는 ${pet.age}`);
	tblHtml += '<tr><td>' + pet.name+'</td><td>' + pet.age+'</td></tr>';
}
tblHtml += '</tbody></table>';

document.querySelector('nav+div.container-fluid').innerHTML += tblHtml;


