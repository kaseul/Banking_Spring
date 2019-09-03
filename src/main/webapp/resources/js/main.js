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
	else {
		
	}
}

function dropdown() {
	document.getElementById("bankDropdown").classList.toggle("show");
}

function selectBank(bcode, bname) {
	document.getElementById("bcode").value = bcode;
	document.getElementById("selectedBank").innerHTML = bname + "  " + "<i class='fas fa-chevron-down'></i>";
}