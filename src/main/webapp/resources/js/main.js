function login() {
    var id = document.getElementById('login_id').value.trim();
    var pw = document.getElementById('login_pw').value.trim();
    
    if(id == "" || pw == "") {
        alert('아이디와 비밀번호를 모두 입력해주세요');
    }
    else {
        document.getElementById('login_form').submit();
    }
}

function remove(msg, url) {
	if(confirm(msg)) {
		location.href=url;
	}
}

function dropdown(id) {
	document.getElementById(id).classList.toggle("show");
	var diffDropdown = document.getElementById("accountDropdown");
	
	if(id == "bankDropdown") {
		diffDropdown = document.getElementById("accountDropdown");
	}
	else {
		diffDropdown = document.getElementById("bankDropdown");
	}
	if(diffDropdown != null && diffDropdown.classList.contains("show")) {
		diffDropdown.classList.remove("show");
	}
}

function selectBank(bcode, bname) {
	document.getElementById("bcode").value = bcode;
	document.getElementById("selectedBank").innerHTML = bname + "<div><i class='fas fa-chevron-down'></i></div>";
}

function selectBankWithCom(bcode, bname, commission) {
	document.getElementById("inbcode").value = bcode;
	document.getElementById("commission").value = commission;
	document.getElementById("selectedBank").innerHTML = bname + "<div><i class='fas fa-chevron-down'></i></div>";
}

function selectAccount(bcode, bname, aid, balance) {
	document.getElementById("outaid").value = aid;
	document.getElementById("outbcode").value = bcode;
	document.getElementById("outbname").value = bname;
	document.getElementById("outbalance").value = balance;
	document.getElementById("selectedAccount").innerHTML = bname + " │ " + aid + "<div><i class='fas fa-chevron-down'></i></div>";
	console.log("selectAccount : " + document.getElementById("outaid").value);
}

function selectRemitAccount(bcode, bname, inaid, commission) {
	document.getElementById("inaid").value = inaid;
	document.getElementById("inbcode").value = bcode;
	document.getElementById("commission").value = commission;
	document.getElementById("selectedRemitAccount").innerHTML = bname + " │ " + inaid + "<div><i class='fas fa-chevron-down'></i></div>";
}

function selectAccountTrans(bcode, bname, aid) {
	document.getElementById("outaid").value = aid;
	document.getElementById("selectedAccount").innerHTML = bname + " │ " + aid + "<div><i class='fas fa-chevron-down'></i></div>";
	console.log("selectAccount : " + document.getElementById("outaid").value);
}