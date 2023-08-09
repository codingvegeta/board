const URL = 'http://localhost:8080'

function postProtocol(url, data, successCallBack, failedCallBack) {
    axios.post(URL + url, data)
        .then(response => {
            console.log(response);
            if (response.data.success) {
                console.log(1);
                successCallBack(response.data);
            } else {
                console.log(2);
                failedCallBack(response.data);
            }
        })
        .catch(err => {
            console.log(3);
            console.log(err);
            failedCallBack(err)
        });
}

function getProtocol(url, successCallBack, failedCallBack) {
    axios.get(URL + url,
        (response) => {
            console.log(1);
            successCallBack(response.data);
        },
        (err) => {
            console.log(2);
            failedCallBack(err);
        }
    )
        .catch(err => {
            console.log(3);
            console.log(err);
            failedCallBack(err)
        });
}

async function returnProtocol(url, data) {
    let response = new Object();
    try {
        data = axios.post(url, data);
        if (response.result) {
            return response.data;
        } else {
            console.log(response.msg);
        }
    } catch (e){
        console.log(e);
    }
}