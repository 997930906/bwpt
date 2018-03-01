$(document).ready(function() {
	//左菜单
	$('.accordion > a').click(function() {
		$(this).addClass("active") //给当前元素添加"current"样式
		.next().show() //下一个元素显示
		.parent().siblings().children("a").removeClass("active") //父元素的兄弟元素的子元素<a>移除"current"样式
		.next().hide(); //它们的下一个元素隐藏
		$(this).parent().addClass("active");
		$(this).parent().siblings().removeClass("active")
		return false;
	});

	//gallery delete
	$('.thumbnails').on('click', '.gallery-delete', function(e) {
		e.preventDefault();
		//get image id
		//alert($(this).parents('.thumbnail').attr('id'));
		$(this).parents('.thumbnail').fadeOut();
	});
	//gallery edit
	$('.thumbnails').on('click', '.gallery-edit', function(e) {
		e.preventDefault();
		//get image id
		//alert($(this).parents('.thumbnail').attr('id'));
	});


});

