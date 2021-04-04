
// 구독자 정보 보기
document.querySelector("#subscribeBtn").onclick = (e) => {
  e.preventDefault();
  document.querySelector(".modal-follow").style.display = "flex";
  
  let userId = $("#userId").val();
	console.log("구독정보 버튼 실행됨?");
 $.ajax({
	 url: `/user/${userId}/follow`,
 }).done((res)=>{	
 
	 $("#follow_list").empty();
	 res.data.forEach((u) => {
		  let item = makeSubscribeInfo(u);
		  $("#follow_list").append(item);
	 }); 
 }).fail((error)=>{
	 alert("오류 : "+error);
	 console.log(error);
 });
};

function makeSubscribeInfo(u){
	let item = `<div class="follower__item" id="follow-${u.userId}">`;
	item += `<div class="follower__img">`;
	item += `<img src="/upload/${u.profileImageUrl}" alt=""  onerror="this.src='/images/person.jpeg'"/>`;
	item += `</div>`;
	item += `<div class="follower__text">`;
	item += `<h2>${u.username}</h2>`;
	item += `</div>`;
	item += `<div class="follower__btn">`;
	if(!u.equalState){
		if(u.followState){
			item += `<button class="cta blue" onclick="followOrUnFollow(${u.userId})">구독취소</button>`;	
			item += `<button class="cta blue" onclick="followOrUnFollowModal(${u.userId})">구독취소</button>`;	
		}else{
			item += `<button class="cta" onclick="followOrUnFollow(${u.userId})">구독하기</button>`;
			item += `<button class="cta" onclick="followOrUnFollowModal(${u.userId})">구독하기</button>`;
		}	
	}
	item += `</div>`;
	item += `</div>`;

	return item;
}

function followOrUnFollowModal(userId){
	let text = $(`#follow-${userId} button`).text();
	
	if(text === "구독취소"){
		$.ajax({
			type: "DELETE",
			url: "/follow/"+userId,
			dataType: "json"
		}).done(res=>{
			$(`#follow-${userId} button`).text("구독하기");
			$(`#follow-${userId} button`).toggleClass("blue");
		});
	}else{
		$.ajax({
			type: "POST",
			url: "/follow/"+userId,
			dataType: "json"
		}).done(res=>{
			$(`#follow-${userId} button`).text("구독취소");
			$(`#follow-${userId} button`).toggleClass("blue");
		});
	}
}
//팔로우 하기
function followOrUnFollowProfile(userId){
	let text = $(`#follow_profile_btn`).text();

	if(text === "구독취소"){
		$.ajax({
			type: "DELETE",
			url: "/follow/"+userId,
			dataType: "json"
		}).done(res=>{
			$(`#follow_profile_btn`).text("구독하기");
			$(`#follow_profile_btn`).toggleClass("blue");
		});
	}else{
		$.ajax({
			type: "POST",
			url: "/follow/"+userId,
			dataType: "json"
		}).done(res=>{
			$(`#follow_profile_btn`).text("구독취소");
			$(`#follow_profile_btn`).toggleClass("blue");
		});
	}
}



//$("#follow-1 button").text("구독하기");
//$("#follow-1 button").클래스명변경("cta");
//
//$("#follow-1 button").text("구독취소");
//$("#follow-1 button").클래스명변경("cta blue");


function closeFollow() {
  document.querySelector(".modal-follow").style.display = "none";
}
document.querySelector(".modal-follow").addEventListener("click", (e) => {
  if (e.target.tagName !== "BUTTON") {
    document.querySelector(".modal-follow").style.display = "none";
  }
});
function popup(obj) {
  console.log(obj);
  document.querySelector(obj).style.display = "flex";
}
function closePopup(obj) {
  console.log(2);
  document.querySelector(obj).style.display = "none";
}
document.querySelector(".modal-info").addEventListener("click", (e) => {
  if (e.target.tagName === "DIV") {
    document.querySelector(".modal-info").style.display = "none";
  }
});
document.querySelector(".modal-image").addEventListener("click", (e) => {
  if (e.target.tagName === "DIV") {
    document.querySelector(".modal-image").style.display = "none";
  }
});


//function clickFollow(e) {
//  let _btn = e;
//  console.log(_btn.textContent);
//  if (_btn.textContent === "구독취소") {
//    _btn.textContent = "구독하기";
//    _btn.style.backgroundColor = "#fff";
//    _btn.style.color = "#000";
//    _btn.style.border = "1px solid #ddd";
//  } else {
//    _btn.textContent = "구독취소";
//    _btn.style.backgroundColor = "#0095f6";
//    _btn.style.color = "#fff";
//    _btn.style.border = "0";
//  }
//}

//회원정보 수정
       function update(userId){
           event.preventDefault();
         let data = $("#profile_setting").serialize();
         console.log(data);

         $.ajax({
            type: "PUT",
            url: "/user/"+userId,
            data: data,
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            dataType: "json"
         }).done(res=>{
            alert("수정 성공");
         });
        }
