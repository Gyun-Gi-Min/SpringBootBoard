(function() {
    'use strict';

    const searchParams = new URL(window.location.href).searchParams;
    const iboard = searchParams.get('iboard');

    const boardDetailElem = document.querySelector('#board_detail');

    const commentFormContainerElem = document.querySelector('#comment_form_container');
    const commentListElem = document.querySelector('#comment_list');


    const getData = () => {
        fetch(`/board/detail_item?iboard=${iboard}`)
            .then(res => res.text())
            .then(data => {
                console.log(data);
                boardDetailElem.innerHTML = data;
            });
    }
    getData();

    //댓글 리스트
    const getCommentList = () => {
        myFetch.get('/ajax/comment',list =>{
            console.log(list);
            makeCommentRecordList(list);
        }, {iboard});
    }

    getCommentList();

    const makeCommentRecordList = list => {
        const tbodyElem = commentListElem.querySelector('table tbody');

        list.forEach(item =>{ //리스트라서 for문 돌리는것.
            const trElem = document.createElement('tr');

            console.log(tbodyElem);
            trElem.innerHTML=`
                <td>${item.icmt}</td>
                <td>${item.ctnt}</td>
                <td>${item.username}</td>
                <td>${item.rdt}</td>
                <td></td>
                
            `;
            tbodyElem.appendChild(trElem);

        })
    }


    if(commentFormContainerElem) {
        const commentSubmitBtnElem = commentFormContainerElem.querySelector('button[name="comment_submit"]');
        const commentCtntInputElem = commentFormContainerElem.querySelector('input[name="ctnt"]');

        commentSubmitBtnElem.addEventListener('click', e => {
            console.log(commentCtntInputElem.value);

            const param = {
                iboard,
                'ctnt': commentCtntInputElem.value
            }

            myFetch.post('/ajax/comment', data => {
                console.log(data.result);
                switch(data.result) {
                    case 0:
                        alert('댓글 전송에 실패하였습니다.');
                        break;
                    case 1:
                        commentCtntInputElem.value = null;
                        break;
                }
            }, param);
        });


    }


})();