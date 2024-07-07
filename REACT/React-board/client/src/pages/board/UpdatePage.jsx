import React from 'react'
import { useParams } from 'react-router-dom'
import UpdateContainer from '../../containers/board/UpdateContainer'

const UpdatePage = () => {
    const {no} = useParams()
    console.log(`no : ${no}`);
  return (
    <>
        <UpdateContainer no={no} />
    </>
  )
}

export default UpdatePage
