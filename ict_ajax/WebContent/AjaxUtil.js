/**
 * 
 */
var AjaxUtil = function(conf) {
			var method = conf.method ? conf.method : 'GET';
			var url = conf.url;
			var params = JSON.stringify(conf.params);
			var type = conf.type ? conf.type : 'json';
			
			var comErr = function(res) {
				alert(res);
			}
			
			var comCb = function(res) {
				alert(res);
			}

			
			var callback = conf.cb ? conf.cb : comCb;
			var errback = conf.err ? conf.err : comErr;
			
			var xhr = new XMLHttpRequest();
			
			xhr.cb = callback;
			xhr.err = errback;
			
			xhr.onreadystatechange = function() {
				if (xhr.readyState == xhr.DONE) {
					if (xhr.status == 200) {
						xhr.cb(xhr.response);
					} else {
						xhr.err(xhr.response);
					}
				}
			}
			
			this.send = function() {
				if(method=='GET') {
					url += '?params=' + encodeURIComponent(params);
				}
				xhr.open(method,url);
				xhr.send(params);
			}
		}