<!DOCTYPE html>
<html lang="zh">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>GEM</title>

    <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="/webjars/datatables/1.10.19/css/dataTables.bootstrap4.min.css" rel="stylesheet">

    <script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="/webjars/popper.js/1.14.7/popper.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="/webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
    <script src="/webjars/datatables/1.10.19/js/dataTables.bootstrap4.min.js"></script>
</head>
<body>

<div id="container">


    <div class="jumbotron text-center">
        <h1>销售订单查询</h1>
    </div>

    <div class="card">
        <div class="card-header">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#searchModal">
                通过客户姓名查询
            </button>

            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#searchModalByGemID">
                通过石号查询
            </button>
        </div>
        <div class="card-body">
            <table id="dataTables-example" class="table table-sm">
                <thead>
                <tr>
                    <th>石号</th>
                    <th>石名称</th>
                    <th>客户名</th>
                    <th>重量</th>
                    <th>克拉价</th>
                    <th>销售时间</th>
                </tr>
                </thead>
                <tbody>
                <#list tableList as item>
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.client}</td>
                        <td>${item.weight}</td>
                        <td>${item.unitPrice}</td>
                        <td>${item.soldTime}</td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>
    document.addEventListener("DOMContentLoaded", event => {
        $('#dataTables-example').DataTable();
    });

    function search() {
        location.assign("/soldList?flag=0&value=" + document.getElementById("recipient-name").value);
    }

    function searchByGemID() {
        location.assign("/soldList?flag=1&value=" + document.getElementById("gem-id").value);
    }
</script>

<div class="modal fade" id="searchModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">检索客户</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">客户名</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="search()">查询</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="searchModalByGemID" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">检索</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="gem-id" class="col-form-label">石号</label>
                        <input type="text" class="form-control" id="gem-id">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="searchByGemID()">查询</button>
            </div>
        </div>
    </div>
</div>
</body>

</html>