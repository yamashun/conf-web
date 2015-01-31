
//--------テーブルの末尾に新規行を追加する関数--------
function addList() {

  // 指定したIDのテーブルを取得する
  var table = document.getElementById("empInd-table");
  //テーブルの行数取得
  var rowCnt = table.rows.length;
  
  //テーブルの行数が８行以上（ヘッダを含め９行以上）の場合処理を抜ける
  if(rowCnt > 8){
	  alert("8行以上は追加できません。");
	  return;
  }
  
  //行内セルの数
  var colCnt = table.rows[0].cells.length;
  //行の末尾に,新規行を追加
  var row = table.insertRow(rowCnt);
  
  //配列cellsに新規作成した行のセルを格納する(後でhtmlを書き込むため)
  var cells = [];
  for(var i =0; i < 8; i++){
	  cells[i] = row.insertCell(i);
  }
  
  //number：社員個別情報の要素数
  var number = rowCnt - 1;
  
  //セルごとにHTMLを作成し、配列HTMLsに格納
  var HTMLs = [];
	HTMLs[0] = '<input id="empInd' + number + '.empName" name="empInd[' + number + '].empName" type="text" style="float:left;" size="5" /><input id="empInd' + number + '.empNum" name="empInd[' + number + '].empNum" type="text" size="5" />';
	HTMLs[1] = '<input id="empInd' + number + '.targetDay" name="empInd[' + number + '].targetDay" type="text" size="7" />';
	HTMLs[2] = '<input id="empInd' + number + '.divisionCode" name="empInd[' + number + '].divisionCode" type="text" size="1" />';
	HTMLs[3] = '<input id="empInd' + number + '.scheduledTimeStart" name="empInd[' + number + '].scheduledTimeStart" type="text" size="2" />～<input id="empInd' + number + '.scheduledTimeFinish" name="empInd[' + number + '].scheduledTimeFinish" type="text" size="2" />';
	HTMLs[4] = '<input id="empInd' + number + '.changeDay" name="empInd[' + number + '].changeDay" type="text" size="7" />';
	HTMLs[5] = '<input id="empInd' + number + '.monthTotalHour" name="empInd[' + number + '].monthTotalHour" type="text" size="3" />';
	HTMLs[6] = '<input id="empInd' + number + '.yearTotalHour" name="empInd[' + number + '].yearTotalHour" type="text" size="3" />';
	HTMLs[7] = '<input id="empInd' + number + '.notes" name="empInd[' + number + '].notes" type="text" size="4" />';
  
  //作成したHTMLを書き込む
  for(var i =0; i < 8; i++){
	  cells[i].innerHTML = HTMLs[i];
  }

}


//------テーブル末尾の行を削除する関数--------
function removeList(){
	// 指定したIDのテーブルを取得する
	var table = document.getElementById("empInd-table")
	//テーブルの行数取得
	var rowCnt = table.rows.length;
	//テーブルの行数が１行（ヘッダ行を含め２行）の場合処理を抜ける。
	 if(rowCnt < 3){
		 alert("行を削除できません。");
		 return;
	 }
	//テーブルの行数取得
	var rowCnt = table.rows.length;
	//末尾の行を削除
	table.deleteRow(rowCnt-1); 
}

