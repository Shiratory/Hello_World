/*
* js/array2.js
*/
const numAry = [10, 17, 23, 26, 49];
let filterAry = numAry.filter(function(item, idx, ary){
	return item % 2 == 0; // true 값을 반환하는 item을 배열로 저장
});
console.log(filterAry);

const jsonStr = `[{"id":1,"first_name":"Silvan","last_name":"Copcutt","email":"scopcutt0@springer.com","gender":"Male","salary":6934},
{"id":2,"first_name":"Alick","last_name":"Quincey","email":"aquincey1@vimeo.com","gender":"Male","salary":2243},
{"id":3,"first_name":"Sadella","last_name":"Nowland","email":"snowland2@google.com.au","gender":"Female","salary":2258},
{"id":4,"first_name":"Andy","last_name":"Fencott","email":"afencott3@utexas.edu","gender":"Female","salary":2940},
{"id":5,"first_name":"Nickola","last_name":"Denford","email":"ndenford4@irs.gov","gender":"Male","salary":7644},
{"id":6,"first_name":"Hanson","last_name":"MacArdle","email":"hmacardle5@archive.org","gender":"Male","salary":3981},
{"id":7,"first_name":"Cristine","last_name":"Fruin","email":"cfruin6@wisc.edu","gender":"Female","salary":5147},
{"id":8,"first_name":"Roanna","last_name":"Georgius","email":"rgeorgius7@toplist.cz","gender":"Female","salary":8358},
{"id":9,"first_name":"Burl","last_name":"Matys","email":"bmatys8@biglobe.ne.jp","gender":"Male","salary":3737},
{"id":10,"first_name":"Lora","last_name":"Kubera","email":"lkubera9@goo.gl","gender":"Bigender","salary":9425},
{"id":11,"first_name":"Lucho","last_name":"Widdowes","email":"lwiddowesa@ebay.com","gender":"Male","salary":4893},
{"id":12,"first_name":"Vladimir","last_name":"Skullet","email":"vskulletb@slashdot.org","gender":"Male","salary":4098},
{"id":13,"first_name":"Pincas","last_name":"Bambery","email":"pbamberyc@booking.com","gender":"Male","salary":3748},
{"id":14,"first_name":"Yoshiko","last_name":"Petrus","email":"ypetrusd@techcrunch.com","gender":"Female","salary":2988},
{"id":15,"first_name":"Vania","last_name":"Rhymer","email":"vrhymere@paginegialle.it","gender":"Female","salary":7688}]`;
const jsonAry = JSON.parse(jsonStr);
// {id, first_name, .....}
	
filterAry = jsonAry.filter((item) => item.gender == "Male" && item.salary >= 5000);
console.log(filterAry);

// reduce()
console.clear();
let result = [10, 23, 34, 48, 51].reduce(function(acc, item){
	console.log(acc, item);
	if (item > 30){
		acc.push(item);
	}
	return acc; //acc값으로 활용
}, []);
console.log('result: ', result);
console.clear();
let list = document.querySelector('#list'); // <ul id = "list" />
console.log(list);

[10, 23, 34, 48, 51].reduce((acc, item) => {
	let li = document.createElement('li');
	li.innerHTML = item; // <li>10</li>
	acc.appendChild(li);
	
	return acc;
}, list);

console.clear();
const ary = [
	{name : "씹창섭", phone : "010-1234-5678"},
	{name : "기길동", phone : "010-1111-2222"},
	{name : "홍흥흠", phone : "010-0130-9876"},
	{name : "김삼순", phone : "010-2222-3333"},
].reduce((acc, item)=>{
	let li = document.createElement('li');
	li.innerHTML = item.name + " - " + item.phone;
	acc.appendChild(li);
	
	return acc;
}, list);