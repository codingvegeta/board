const URL = 'http://localhost:8080'

function protocol(url, method, data, successCallBack, failedCallBack)
{
    if (method === 'post') {
        axios.post(URL + url, data,
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
    if (method === 'get') {
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
}