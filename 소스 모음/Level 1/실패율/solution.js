function solution(N, stages) {
    var answer = [];
    var num = stages.length;
    var temp = [];                
    for(var i = 1; i <= N; i++){
        answer[i-1] = i;
    }
    temp = new Array(N).fill(0);

    stages.forEach(function(x){
        if(x <= N){
            temp[x-1]++;
        }
    });

    temp = temp.flatMap(function(numByStage,index){
        var remained = num;
        num -= numByStage;
        return numByStage/remained;
    })

    answer = answer.sort(function(a,b){
        return parseFloat(temp[b-1]) - parseFloat(temp[a-1]);
    });

    return answer;
}