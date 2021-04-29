variable "region" {
    default = "ap-northeast-1"
}

variable "images" {
    default = {
        us-east-1 = "ami-lecae776"
        ap-northeast-1 = "ami-cbf90ecb"
    }
}

provider "aws" {
    region = var.region
}

resource "aws_vpc" "my_vpc" {
    cidr_block = "10.1.0.0/16"
    instance_tenancy = "default"
    enable_dns_support = "true"
    enable_dns_hostnames = "false"
    tags = {
        Name = "my_vpc"
    }
}

resource "aws_internet_gateway" "my_gw" {
    vpc_id = aws_vpc.my_vpc.id
    depends_on = [aws_vpc.my_vpc]
}

resource "aws_subnet" "public_a" {
    vpc_id = aws_vpc.my_vpc.id
    cidr_block = "0.0.0.0/24"
    availability_zone = "ap-northeast-1a"
}

resource "aws_route_table" "public_route" {
    vpc_id = aws_vpc.my_vpc.id
    route {
        cidr_block = "0.0.0.0/0"
        gateway_id = aws_internet_gateway.my_gw.id
    }
}

resource "aws_route_table_association" "public_a" {
    subnet_id = aws_subnet.public_a.id
    route_table_id = aws_route_table.public_route.id
}

resource "aws_security_group" "admin" {
    name = "admin"
    description = "Allow SSH inbound traffic"
    vpc_id = aws_vpc.my_vpc.id
    ingress {
        from_port = 22
        to_port = 22
        protocol = "tcp"
        cidr_blocks = ["0.0.0.0/0"]
    }
    egress {
        from_port = 0
        to_port = 0
        protocol = "-1"
        cidr_blocks = ["0.0.0.0/0"]
    }
}

resource "aws_instance" "my_test" {
    ami = var.images.ap-northeast-1
    instance_type = "t2.micro"
    key_name = "ope-numa"
    vpc_security_group_ids= [
        aws_security_group.admin.id
    ]
    subnet_id = aws_subnet.public_a.id
    associate_public_ip_address = "true"
    root_block_device {
        volume_type = "gp2"
        volume_size = "20"
    }
    ebs_block_device {
        device_name = "/dev/sdf"
        volume_type = "gp2"
        volume_size = "100"
    }
    tags = {
        Name = "my_test"
    }
}

output "public_ip_of_my_test" {
 value = aws_instance.my_test.public_ip
}

