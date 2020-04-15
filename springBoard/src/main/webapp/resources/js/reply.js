/**
 * 댓글 자바스크립트 모듈화
 */

var replyService = (function(){
	
	function add(reply, callback, error){
		console.log("add reply..");
		$.ajax({
			type : 'post', // (==method)보낼 타입, default는 get
			url : '/reply/newReply', // 보낼 주소
			data : JSON.stringify(reply),//JavaScript 값이나 객체(reply)를 JSON 문자열로 변환
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if(callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if(error) {
					error(er);
				}
			}
		})
	}
	
	function getList(param, callback, error) {
		var article_id = param.article_id;
		var page = param.page || 1;
		$.getJSON("/reply/replyList/" + article_id + "/" + page + ".json",
			function(data) {
				if(callback) {
					//callback(data); //댓글 목록(list)만 가져오는 경우
					console.log(data);
					callback(data.list, data.pageMaker);
				}
			}).fail(function(xhr, status, err) {
				if(error) {
					error();
				}
			});
	}
	
	function remove(reply_id, callback, error) {
		$.ajax({
			type : 'delete',
			url : '/reply/' + reply_id,
			success : function(deleteResult, status, xhr) {
				if(callback) {
					callback(deleteResult);
				}
			},
			error : function(xhr, status, er) {
				if(error) {
					error(er);
				}
			}
		});
	}
	
	function update(reply, callback, error) {
		console.log("reply_id : " + reply.reply_id);
		$.ajax({
			type : 'put',
			url : '/reply/' + reply.reply_id,
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if(callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if(error) {
					error(er);
				}
			}
		});
	}
	
	function displayTime(timeValue) {
		var today = new Date();
		var gap = today.getTime() - timeValue;
		var dateObj = new Date(timeValue);
		var str = "";
		if(gap < (1000 * 60 * 60 * 24)) {
			var hh = dateObj.getHours();
			var mi = dateObj.getMinutes();
			var ss = dateObj.getSeconds();
			return [ (hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi/*, ':', (ss > 9 ? '' : '0') + ss */].join('');
		} else {
			var yy = dateObj.getFullYear();
			var mm = dateObj.getMonth() +1; //getMonth()는 0부터 -> +1 필요
			var dd = dateObj.getDate();
			return [ yy, '/', (mm > 9 ? '' : '0') + mm, '/', (dd > 9 ? '' : '0') + dd ].join('');
		}
	}
	;
	
	return {
		add : add,
		getList : getList,
		remove : remove,
		update : update,
		displayTime : displayTime
	};
})();