/* 
    jQuery 애니메이션 함수
    - hide/show
    - fade
    - slide
    - animate
*/

$(function() {

    /* hide & show */
    /* 
        hide/show( 인자1, 인자2 )
        * 인자1 : duration (시간)
        - margin, padding, width, height, opacity 속성 등을
        지정된 값에서 0으로, 지정시간(ms) 동안 애니메이션 동작을 한다.
        그 이후에, display : none 으로 변경되어 사라진다.
        (1s = 1000ms)

        * 인자2 : 콜백함수
        - 애니메이션 완료 후, 호출할 콜백 함수
    */

    $('.hide').on('click', function() {
        $('#box1').hide()
    })

    $('.show').on('click', function() {
        $('#box1').show()
    })

    $('.hide1000').on('click', function() {
        $('#box1').hide(1000)
    })

    $('.show1000').on('click', function() {
        $('#box1').show(1000)
    })

    /*
        fadeXXX( 인자1 )
        * 인자1 : duration  (시간 : ms), ('slow', 'fast')

        fadeXXX( 인자1, 인자2 )
        * 인자1 : duration  (시간 : ms), ('slow', 'fast')
        * 인자2 : function() - 애니메이션 후, 실행할 콜백함수
        
        fadeXXX( 인자1, 인자2, 인자3 )
        * 인자1 : duration  (시간 : ms), ('slow', 'fast')
        * 인자2 : easing (swing, linear)
        * 인자3 : function() - 애니메이션 후, 실행할 콜백함수
        
        fadeTo( 인자1, 인자2, 인자3, 인자4 )
        * 인자1 : duration  (시간 : ms), ('slow', 'fast')
        * 인자2 : opacity (불투명도 : 0.0 ~ 1)
        * 인자3 : easing (swing[default], linear)
        * 인자4 : function() - 애니메이션 후, 실행할 콜백함수
    */

    /* fadeOut */
    $('.fadeOut').on('click', function() {
        $('#box2').fadeOut(1000)
    })
    
    /* fadeIn */
    $('.fadeIn').on('click', function() {
        $('#box2').fadeIn(1000)
    })
    
    /* fadeToggle */
    $('.fadeToggle').on('click', function() {
        $('#box2').fadeToggle(1000)
    })
    
    /* fadeTo */
    $('.fadeTo').on('click', function() {
        $('#box2').fadeTo('slow', 0.2)
    })


    /* 
        slideXXX( 인자1, 인자2 )
        * 인자1 : duration  (시간 : ms), ('slow', 'fast')
        * 인자2 : 콜백함수
        
        slideXXX( 인자1, 인자2, 인자3 )
        * 인자1 : duration  (시간 : ms), ('slow', 'fast')
        * 인자2 : easing (swing[default], linear)
        * 인자3 : 콜백함수
    */

    $('.slideUp').on('click', function() {
            $('#box3').slideUp(1000)
    })

    $('.slideDown').on('click', function() {
            $('#box3').slideDown(1000)
    })

    $('.slideToggle').on('click', function() {
            $('#box3').slideToggle(1000)
    })

    // animate
    let sw = false      // 버튼 클릭 여부
    $('.animate').on('click', function() {
        
        if( !sw ) {
            $('#box4').stop().animate({
                'opacity'       : '0.3',
                'width'         : '600px',
                'background-color'  : 'red'
            }, 3000)
        }
        else {
            $('#box4').animate({
                'opacity'       : '1',
                'width'         : '150px',
            }, 3000)
        }
        sw = !sw
    })

    /* 
        animate() 함수로 지정가능한 스타일 속성
        : backgroundPositionX, backgroundPositionY, borderBottomWidth, borderLeftWidth
        , borderRightWidth, borderSpacing, borderTopWidth, borderWidth, bottom, fontSize
        , height, left, letterSpacing, lineHeight, margin, marginBottom, marginLeft, marginRight, marginTop
        , maxHeight, maxWidth, minHeight, minWidth, opacity, outlineWidth
        , padding, paddingBottom, paddingLeft, paddingRight, paddingTop, right, textIndent, top, width, wordSpacing
        
    */

    let flag = true
    $('.active').on('click', function() {
        $('#box5').attr('class', 'target-box')
        if( flag ) {
            $('#box5').addClass('active')
        }
        else {
            $('#box5').addClass('reset')
        }
        flag = !flag
    })
    // addClass()           : 클래스 속성 추가
    // removeClass()        : 클래스 속성 제거
})

