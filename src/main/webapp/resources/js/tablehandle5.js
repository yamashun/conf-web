/**
 * 
 */

function addList(obj) {

  // 指定したIDのテーブルを取得し、変数「tbl」に代入
  var table = document.getElementById("empInd-table");
  //テーブルの行数取得
  var rowCnt = table.rows.length;
  //行内セルの数
  var colCnt = table.rows[0].cells.length;
  //行の末尾に,新規行を追加
  var row = table.insertRow(rowCnt);
  
 // for (var i = 0; i < colCnt; i ++) { // セルの数だけループして
	     //row.insertCell(i);// 追加した行にセルを挿入
	     // cell.innerHTML = "行"+rowCnt+"-列"+i; // 行,セルIndex値 表示
  //}
  var cell1 = row.insertCell(0);
  var cell2 = row.insertCell(1);
  var cell3 = row.insertCell(2);
  var cell4 = row.insertCell(3);
  var cell5 = row.insertCell(4);
  var cell6 = row.insertCell(5);
  var cell7 = row.insertCell(6);
  var cell8 = row.insertCell(7);
  var cell9 = row.insertCell(8);
  
  
  var number = rowCnt - 1;
  
	var HTML1 = '<input id="empInd' + number + '.empName" name="empInd[' + number + '].empName" type="text" style="float:left;" size="5" /><input id="empInd' + number + '.empNum" name="empInd[' + number + '].empNum" type="text" size="5" />';
	var HTML2 = '<input id="empInd' + number + '.targetDay" name="empInd[' + number + '].targetDay" type="text" size="7" />';
	var HTML3 = '<input id="empInd' + number + '.divisionCode" name="empInd[' + number + '].divisionCode" type="text" size="1" />';
	var HTML4 = '<input id="empInd' + number + '.scheduledTimeStart" name="empInd[' + number + '].scheduledTimeStart" type="text" size="2" />～<input id="empInd' + number + '.scheduledTimeFinish" name="empInd[' + number + '].scheduledTimeFinish" type="text" size="2" />';
	var HTML5 = '<input id="empInd' + number + '.changeDay" name="empInd[' + number + '].changeDay" type="text" size="7" />';
	var HTML6 = '<input id="empInd' + number + '.monthTotalHour" name="empInd[' + number + '].monthTotalHour" type="text" size="3" />';
	var HTML7 = '<input id="empInd' + number + '.yearTotalHour" name="empInd[' + number + '].yearTotalHour" type="text" size="3" />';
	var HTML8 = '<input id="empInd' + number + '.notes" name="empInd[' + number + '].notes" type="text" size="4" />';
	var HTML9 = '<input type="button" value="+" onclick="addList(this);"><input type="button" value="-" onclick="removeList(this.name);" name="' + rowCnt + '">';
    
	cell1.innerHTML = HTML1;
	cell2.innerHTML = HTML2;
	cell3.innerHTML = HTML3;
	cell4.innerHTML = HTML4;
	cell5.innerHTML = HTML5;
	cell6.innerHTML = HTML6;
	cell7.innerHTML = HTML7;
	cell8.innerHTML = HTML8;
	cell9.innerHTML = HTML9;

}


function removeList(obj){
	var table = document.getElementById("empInd-table");
	table.deleteRow(obj); 
	
	
}

