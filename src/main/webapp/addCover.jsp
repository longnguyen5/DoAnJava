<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>

<!-- Modal -->
<div class="modal fade" id="staticBackdrop1" data-bs-backdrop="static"
	data-bs-keyboard="false" tabindex="-1"
	aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
	<form action="AddCoverServlet" method="get">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="staticBackdropLabel">Thêm Cover</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<h6 style="color: red;">${error}</h6>
				<div class="mb-3 ml-3 row">
					<label for="coverId" class="col-form-label">ID
						</label>
					<div class="">
						<input class="form-control" type="text" name="coverId"
							placeholder="Default input" aria-label="default input example">
					</div>
				</div>
				<div class="mb-3 ml-3 row">
					<label for="coverName" class="col-form-label">Tên hiển thị
						</label>
					<div class="">
						<input class="form-control" type="text" name="coverName"
							placeholder="Default input" aria-label="default input example">
					</div>
				</div>
				<div class="mb-3 ml-3 row">
					<label for="description" class="col-form-label">Mô tả thêm</label>
					<div class="">
						<input class="form-control" type="text" name="description"
							placeholder="Default input" aria-label="default input example">
					</div>
				</div>
				<div class="mb-3 ml-3 row">
					<label for="link" class="col-form-label">Đường dẫn</label>
					<div class="">
						<input class="form-control" type="text" name="link"
							placeholder="Default input" aria-label="default input example">
					</div>
				</div>
				<div class="mb-3 ml-3 row">
					<label for="status" class="col-form-label">Trạng
						thái hiển thị</label>
					<div class="">
						<select class="form-select" name="status"
							aria-label="Default select example">
							<option selected>Chọn trạng thái</option>
							<option value="1">Hiển thị</option>
							<option value="0">Không hiển thị</option>
						</select>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Đóng</button>
				<button type="submit" class="btn btn-primary">Lưu</button>
			</div>
		</div>
		</form>
	</div>
</div>

</html>