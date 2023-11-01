<template>
    <div style="margin: 0 -15px 0 -15px;">
        <v-card-title>
            {{label}}
        </v-card-title>
        <v-card-text v-if="email">
            <div v-if="editMode" style="margin-top:-20px;">
                <v-text-field label="Address" v-model="email.address"/>
            </div>
            <div v-else>
                Address :  {{email.address }}
            </div>
            <div v-if="editMode" style="margin-top:-20px;">
                <v-text-field label="Subject" v-model="email.subject"/>
            </div>
            <div v-else>
                Subject :  {{email.subject }}
            </div>
            <div v-if="editMode" style="margin-top:-20px;">
                <v-text-field label="Content" v-model="email.content"/>
            </div>
            <div v-else>
                Content :  {{email.content }}
            </div>
        </v-card-text>
    </div>
</template>

<script>

    export default {
        name:"Email",
        props: {
            editMode: Boolean,
            value : Object,
            label : String,
        },
        data: () => ({
            email:{}
        }),
        created(){
            this.email = this.modelValue
            if(!this.email) {
                this.email = {
                    'address': '',
                    'subject': '',
                    'content': '',
                };
            }
        },
        watch: {
            email(newVal) {
                this.$emit('update:modelValue', newVal);
            },
        },
    }
</script>

<style scoped>
    .address-v-card-title {
        display: contents;
    }
    .address-v-text-field {
        margin-top:5px;
    }
</style>