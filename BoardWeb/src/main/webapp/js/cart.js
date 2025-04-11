let basket = {
  changePnum: function(idx, diff = 0) {
    let rows = document.querySelectorAll('.row.data');
    let row = rows[idx];
	console.log(row);

    let priceInput = row.querySelector('.p_price'); // 개당가격
    let numInput = row.querySelector('.p_num'); // 수량
    let sumDiv = row.querySelector('.sum'); // 합계

    let unitPrice = parseInt(priceInput.value);
    let quantity = parseInt(numInput.value) || 0;

    // diff(±1)가 전달되면 수량에 적용
    if (diff !== 0) {
      quantity += diff;
      if (quantity < 1) quantity = 1; // 최소 수량 제한
      numInput.value = quantity;
    }

    // 합계 계산
    let total = unitPrice * quantity;
    sumDiv.textContent = total.toLocaleString() + '원';

    // 전체 합계 재계산
    this.recalcSum();
  },

  // 이하 기존 함수들은 그대로 유지...
  delItem: function() {
    const target = event.target.closest('.row.data');
    target.remove();
    this.recalcSum();
  },

  delCheckedItem: function() {
    const checkedBoxes = document.querySelectorAll('.row.data input[type="checkbox"]:checked');
    checkedBoxes.forEach(box => {
      box.closest('.row.data').remove();
    });
    this.recalcSum();
  },

  delAllItem: function() {
    const allRows = document.querySelectorAll('.row.data');
    allRows.forEach(row => row.remove());
    this.recalcSum();
  },

  recalcSum: function() {
    const rows = document.querySelectorAll('.row.data');
    let totalCnt = 0;
    let totalPrc = 0;

    rows.forEach(row => {
      const checkbox = row.querySelector('input[type = "checkbox"]');
      if (checkbox.checked) {
        const price = parseInt(row.querySelector('.p_price').value);
        const quantity = parseInt(row.querySelector('.p_num').value) || 0;
        totalCnt += quantity;
        totalPrc += price * quantity;
      }
    });
    document.querySelector('#sum_p_num span').textContent = totalCnt;
    document.querySelector('#sum_p_price span').textContent = totalPrc.toLocaleString();
  }
};

window.addEventListener('load', () => {
  basket.recalcSum(); // 페이지 처음 로딩할 때 합계 계산
});
window.basket = basket;
