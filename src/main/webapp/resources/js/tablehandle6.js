/**
 * 
 *//**
 * 
 */

function addList(obj) {

  // 指定したIDのテーブルを取得し、変数「table」に代入
  var table = document.getElementById("empInd-table");
  //テーブルの行数取得
  var rowCnt = table.rows.length;
  //行内セルの数
//  var colCnt = table.rows[0].cells.length;
  //行の末尾に,新規行を追加
  var row = table.insertRow(rowCnt);
  
  var cells = [];
  
  for(var i =0; i < 9; i++){
	  cells[i] = row.insertCell(i);
  }
  
  //number：社員個別情報の要素数
  var number = rowCnt - 1;
  
  var HTMLs = [];
  
	HTMLs[0] = '<input id="empInd' + number + '.empName" name="empInd[' + number + '].empName" type="text" style="float:left;" size="5" /><input id="empInd' + number + '.empNum" name="empInd[' + number + '].empNum" type="text" size="5" />';
	HTMLs[1] = '<input id="empInd' + number + '.targetDay" name="empInd[' + number + '].targetDay" type="text" size="7" />';
	HTMLs[2] = '<input id="empInd' + number + '.divisionCode" name="empInd[' + number + '].divisionCode" type="text" size="1" />';
	HTMLs[3] = '<input id="empInd' + number + '.scheduledTimeStart" name="empInd[' + number + '].scheduledTimeStart" type="text" size="2" />～<input id="empInd' + number + '.scheduledTimeFinish" name="empInd[' + number + '].scheduledTimeFinish" type="text" size="2" />';
	HTMLs[4] = '<input id="empInd' + number + '.changeDay" name="empInd[' + number + '].changeDay" type="text" size="7" />';
	HTMLs[5] = '<input id="empInd' + number + '.monthTotalHour" name="empInd[' + number + '].monthTotalHour" type="text" size="3" />';
	HTMLs[6] = '<input id="empInd' + number + '.yearTotalHour" name="empInd[' + number + '].yearTotalHour" type="text" size="3" />';
	HTMLs[7] = '<input id="empInd' + number + '.notes" name="empInd[' + number + '].notes" type="text" size="4" />';
	HTMLs[8] = '<input type="button" value="+" onclick="addList(this);"><input type="button" value="-" onclick="removeList(this.name);" name="' + rowCnt + '">';
    
  for(var i =0; i < 9; i++){
	  cells[i].innerHTML = HTMLs[i];
  }

}


function removeList(obj){
	var table = document.getElementById("empInd-table");
	table.deleteRow(obj); 
}

