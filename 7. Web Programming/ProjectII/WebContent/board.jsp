<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>고객의견 작성</title>
<!-- css -->
<link rel="stylesheet" href="./css/board.css">
<link rel="stylesheet" href="./css/header.footer.css">

</head>

<body>

	<div class="board_wrap">
		<div class="board_title">
			<strong>고객의견</strong>
			<p>고객님 의견의 답변을 빠르게 안내해드리겠습니다.</p>
		</div>
		<div class="board_write_wrap">
			<form action="/insert.do">
				<div class="board_write">
					<div class="title">
						<dl>
							<dt>제목</dt>
							<dd>
								<input type="text" placeholder="제목 입력" value="글 제목이 들어갑니다">
							</dd>
						</dl>
					</div>
					<div class="info">
						<dl>
							<dt>글쓴이</dt>
							<dd>
								<input type="text" placeholder="글쓴이 입력" value="김이름">
							</dd>
						</dl>
						<!-- <dl>
							<dt>비밀번호</dt>
							<dd>
								<input type="password" placeholder="비밀번호 입력" value="1234">
							</dd>
						</dl> -->
					</div>
					<div class="cont">
						<textarea placeholder="내용 입력"></textarea>
					</div>
				</div>
				<div class="bt_wrap">
					<input type="submit" class="on">보내기 <a href="/list.do">취소</a>
				</div>
			</form>
		</div>
	</div>
</body>

</html>