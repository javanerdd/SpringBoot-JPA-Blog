let index={
	init: function(){
		$("#btn-save").on("click",()=>{ //function(){} , ()=>{}를 사용하는이유는 this를 바인딩하기 위해서 사용
			this.save();
		});
		$("#btn-login").on("click",()=>{ 
			this.login();
		});
	},
	
	save: function(){
		//alter('user의 save함수 호출됨');
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		//console.log(data);
		
		//회원가입시 ajax를 사용하는 이유 2가지
		//1.요청에 대한 응답을 html이 아닌 data(json)를 받기 위해서
		
		
		//ajax 호출시 default가 비동기 호출
		// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
		
		//ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해줌
		$.ajax({
			//회원가입 수행요청
			type: "POST",
			url: "/api/user",
			data: JSON.stringify(data), // http body데이터
			contentType:"application/json; charset=utf-8", //body 데이터가 어떤 타입인지(MIME)
			dataType:"json" 
			// 요청을 서버로 해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 json이라면)=>javascript 오브젝트로 변경

		}).done(function(resp){
			alert("회원가입이 완료 되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error))
		}); 
		
	},
	
	login: function(){
		//alter('user의 save함수 호출됨');
		let data = {
			username: $("#username").val(),
			password: $("#password").val()
		};
 
		$.ajax({
			type:"POST",
			url:"/api/user/login",
			data: JSON.stringify(data), // http body데이터
			contentType:"application/json; charset=utf-8", //body 데이터가 어떤 타입인지(MIME)
			dataType:"json" 

		}).done(function(resp){
			alert("로그인 완료 되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error))
		}); 
		
	}
	
}
index.init();









