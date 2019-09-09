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

function join() {
    var id = document.getElementById('join_id').value.trim();
    var name = document.getElementById('join_name').value.trim();
    var pw = document.getElementById('join_pw').value.trim();
    var pw_check = document.getElementById('join_pw_check').value.trim();
    var birth = document.getElementById('join_birth').value.trim();
    var tel = document.getElementById('join_tel').value.trim();
    
    if(id == "" || name == "" || pw == "" || pw_check == "" || birth == "" || tel == "") {
        alert('양식을 모두 입력해주세요');
    }
    else if(pw != pw_check) {
        alert('같은 비밀번호를 입력해주세요')
    }
    else {
        document.getElementById('join_form').submit();
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

function selectAccount(bcode, bname, aid) {
	document.getElementById("outaid").value = aid;
	document.getElementById("outbcode").value = bcode;
	document.getElementById("outbname").value = bname;
	document.getElementById("selectedAccount").innerHTML = bname + " │ " + aid + "<div><i class='fas fa-chevron-down'></i></div>";
	console.log("selectAccount : " + document.getElementById("outaid").value);
}