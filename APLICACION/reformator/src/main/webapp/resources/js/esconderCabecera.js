$(window).scroll(function () { 
	$(this).scrollTop() < 100 ?
        $('header').removeClass('hidden'):
		$('header').addClass('hidden');
});