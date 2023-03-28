// 간단한 문제를 javascript로 풀어봤습니다
function solution(numbers) {
    var answer = [];
    numbers.forEach(function(e,idx){
        for(var i = idx +1 ; i < numbers.length; i++){
            var value = e + numbers[i];
            if(answer.indexOf(value) === -1){
                answer.push(value);
            }
        }
    });
    
    return answer.sort(function(a,b){
        return a-b;
    });
}